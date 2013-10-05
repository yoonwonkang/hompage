package net.bitacademy.java41.controls.member;

import java.io.File;

import javax.servlet.ServletContext;

import net.bitacademy.java41.service.MemberService;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;


@Controller
@SessionAttributes("myInfo")
@RequestMapping("/member")
public class MemberControl{
	@Autowired MemberService memberService;
	@Autowired ServletContext sc;
	long currTime = 0;
	int count = 0;

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addForm() {
		return "member/newForm";
	}

	//무조건 고쳐야되는 코드...
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add2(
//			String email, String password, String name, String tel, String blog, String detailAddr, int memLevel,
			Member member,
			MultipartFile memImg,
			BindingResult result) throws Exception {
//		Member member = new Member().setEmail(email).setPassword(password).setName(name).setTel(tel).setBlog(blog).setDetailAddr(detailAddr).setMemLevel(memLevel);
		String filename = null;
		if(memImg.getSize() > 0){
			filename= this.getNewFileName();
			String path = sc.getAttribute("rootRealPath") + "file/" + filename;
			memImg.transferTo(new File(path));
			member.setPhotos(new String[]{filename});
		}

		memberService.signUp(member);

		return "redirect:list.do";
	}
	
	@RequestMapping("/delete")
	public String delete(String email) throws Exception {
		memberService.deleteMember(email);
		return "redirect:list.do";
	}


	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		model.addAttribute("list", memberService.getMemberList());
		return "member/list";
	}


	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateForm(String email, Model model) throws Exception {
		model.addAttribute("memberInfo", memberService.getMember(email));
		return "member/updateForm";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(
			Member member,
			MultipartFile photo, 
			Model model) throws Exception {
		String filename = null;
		
		if(photo.getSize() > 0){
			filename= this.getNewFileName();
			String path = sc.getAttribute("rootRealPath") + "file/" + filename;
			photo.transferTo(new File(path));
			member.setPhotos(new String[]{filename});
		}
		
		memberService.update(member);
		return "redirect:../main.do";
	}


	/* 관리자모드 바로 비밀번호 변경시 */
	@RequestMapping(value="/admpasswordChange", method=RequestMethod.GET)
	public String admpasswordForm(String email, Model model) throws Exception {
		model.addAttribute("email", email);
		return "member/admpasswordForm";
	}

	@RequestMapping(value="/admpasswordChange", method=RequestMethod.POST)
	protected String admchangePassword(String email,
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
		return "member/admpasswordChangeResult";
	}


	synchronized private String getNewFileName() {
		long millis = System.currentTimeMillis(); //1000
		if (currTime != millis) {
			currTime = millis;
			count = 0;
		}
		return "member_" + millis + "_" + (++count);
	}

	@RequestMapping("/view")
	public String view(Model model, String email) throws Exception {
		model.addAttribute("memberInfo", memberService.getMember(email));
		return "member/view";
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
		return "member/myInfopasswordChangeResult";
	}
	/* 개인정보 비밀번호 변경시	*/
	@RequestMapping(value="/myInfopasswordChange", method=RequestMethod.GET)
	public String myInfopasswordForm() {
		return "member/myInfopasswordForm";
	}
	/* 개인정보 비밀번호 변경시	*/
	@RequestMapping(value="/myInfopasswordChange", method=RequestMethod.POST)
	protected String myInfochangePassword(
			String email,
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
		return "member/myInfopasswordChangeResult";
	}

	/* 개인정보 변경시 */
	@RequestMapping(value="/updateMyInfo",method=RequestMethod.GET)
	public String myInfoUpdateForm(
			@ModelAttribute("myInfo") Member member,
			Model model) throws Exception {
		model.addAttribute("memberInfo", memberService.getMember(member.getEmail()));
		return "member/updateMyInfo";
	}
	/* 개인정보 변경시 */
	@RequestMapping(value="/updateMyInfo",method=RequestMethod.POST)
	public String myInfoUpdate(
			Member member, 
			MultipartFile photo, 
			Model model) throws Exception {
		
		String filename = null;
		Member origin = null;
		if(photo.getSize() > 0){
			filename= this.getNewFileName();
			String path = sc.getAttribute("rootRealPath") + "file/" + filename;
			photo.transferTo(new File(path));
			origin = memberService.getMember(member.getEmail());
			member.setPhotos(new String[]{filename});
		}
		
		memberService.updateMyInfo(member, origin);
		model.addAttribute("myInfo",member);
		return "redirect:../main.do";
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
		return "member/passwordChangeResult";
	}


}