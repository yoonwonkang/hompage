package net.bitacademy.java41.controls.member;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.service.MemberService;
import net.bitacademy.java41.vo.Member;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/member")
public class MemberControl{
	@Autowired MemberService memberService;
	@Autowired ServletContext sc;
	long currTime = 0;
	int count = 0;

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addForm() {
		return "/member/newForm.jsp";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Member member, MultipartFile photo) throws Exception {
		String filename = this.getNewFileName();
		String path = sc.getAttribute("rootRealPath") + "file/" + filename;
		photo.transferTo(new File(path));
		member.setPhotos(new String[]{filename});

		memberService.signUp(member);

		return "redirect:list.do";
	}

	synchronized private String getNewFileName() {
		long millis = System.currentTimeMillis(); //1000
		if (currTime != millis) {
			currTime = millis;
			count = 0;
		}
		return "member_" + millis + "_" + (++count);
	}

	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		model.addAttribute("list", memberService.getMemberList());
		return "/member/list.jsp";
	}

	@RequestMapping("/view")
	public String view(Model model, String email) throws Exception {
		model.addAttribute("memberInfo", memberService.getMember(email));
		return "/member/view.jsp";
	}

	/* 개인정보 비밀번호 변경시	*/
	@RequestMapping("/myInfopasswordControl")
	public String myInfoPassword(
			String email,
			String password,
			String newPassword,
			String newPassword2,
			Model model) throws Exception {

		if (newPassword.equals(newPassword2)) {
			if (memberService.changePassword(email, password, newPassword)) {
				model.addAttribute("status", "SUCCESS");
			} else {
				model.addAttribute("status", "OLD_PASSWORD_ERROR");
			}
		} else {
			model.addAttribute("status", "NEW_PASSWORD_ERROR");
		}
		return "/member/myInfopasswordChangeResult.jsp";
	}
	/* 개인정보 비밀번호 변경시	*/
	@RequestMapping(value="/myInfopasswordChange", method=RequestMethod.GET)
	public String myInfopasswordForm() {
		return "/member/myInfopasswordForm.jsp";
	}
	/* 개인정보 비밀번호 변경시	*/
	@RequestMapping(value="/myInfopasswordChange", method=RequestMethod.POST)
	protected String myInfochangePassword(String email,
			String oldPassword,
			String newPassword,
			String newPassword2,
			Model model)	throws Exception {

		if (newPassword.equals(newPassword2)) {
			if (memberService.changePassword(email, oldPassword, newPassword)) {
				model.addAttribute("status", "SUCCESS");
			} else {
				model.addAttribute("status", "OLD_PASSWORD_ERROR");
			}
		} else {
			model.addAttribute("status", "NEW_PASSWORD_ERROR");
		}
		return "/member/myInfopasswordChangeResult.jsp";
	}

	/* 개인정보 변경시 */
	@RequestMapping(value="/updateMyInfo",method=RequestMethod.GET)
	public String myInfoUpdateForm(HttpSession session, Model model) throws Exception {
		Member member = (Member)session.getAttribute("member");
		model.addAttribute("memberInfo", memberService.getMember(member.getEmail()));
		return "/member/updateMyInfo.jsp";
	}
	/* 개인정보 변경시 */
	@RequestMapping(value="/updateMyInfo",method=RequestMethod.POST)
	public String myInfoUpdate(Member member, MultipartFile photo, HttpSession session) throws Exception {
		String filename = this.getNewFileName();
		String path = sc.getAttribute("rootRealPath") + "file/" + filename;
		photo.transferTo(new File(path));
		member.setPhotos(new String[]{filename});
		memberService.updateMyInfo(member, session);
		session.setAttribute("member",member);
		return "redirect:../main.do";
	}

	@RequestMapping("/delete")
	public String delete(String email) throws Exception {
		memberService.deleteMember(email);
		return "redirect:list.do";
	}

	/* 관리자모드 바로 비밀번호 변경시 */
	@RequestMapping(value="/admpasswordChange", method=RequestMethod.GET)
	public String admpasswordForm(String email, Model model) throws Exception {
		Member member = memberService.getMember(email);
		model.addAttribute("memberInfo", member);
		return "/member/admpasswordForm.jsp";
	}

	@RequestMapping(value="/passwordChange", method=RequestMethod.POST)
	protected String changePassword(String email,
			String password,
			String newPassword,
			String newPassword2,
			Model model)	throws Exception {

		if (newPassword.equals(newPassword2)) {
			if (memberService.changePassword(email, password, newPassword)) {
				model.addAttribute("status", "SUCCESS");
			} else {
				model.addAttribute("status", "OLD_PASSWORD_ERROR");
			}
		} else {
			model.addAttribute("status", "NEW_PASSWORD_ERROR");
		}
		model.addAttribute("email", email);
		return "/member/passwordChangeResult.jsp";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateForm(String email, Model model) throws Exception {
		model.addAttribute("memberInfo", memberService.getMember(email));
		return "/member/updateForm.jsp";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(
			Member member, 
			MultipartFile photo, 
			Model model) throws Exception {
		String filename = this.getNewFileName();
		String path = sc.getAttribute("rootRealPath") + "file/" + filename;
		photo.transferTo(new File(path));
		member.setPhotos(new String[]{filename});
		memberService.update(member);
		model.addAttribute("memberInfo",member);
		return "redirect:../main.do";
	}
}