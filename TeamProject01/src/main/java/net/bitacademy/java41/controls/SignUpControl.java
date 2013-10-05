package net.bitacademy.java41.controls;

import java.io.File;

import javax.servlet.ServletContext;

import net.bitacademy.java41.service.MemberService;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SessionAttributes("myInfo")
@RequestMapping("/member")
public class SignUpControl{
	@Autowired MemberService memberService;
	@Autowired ServletContext sc;
	long currTime = 0;
	int count = 0;
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(
			Member member,
			String configPassword,
			MultipartFile photo,
			Model model
			) throws Exception {

		//아이디 중복확인
		if(memberService.emailDoubleCheck(member.getEmail())){
			return "member/signUpError";
		}
		//암호확인
		if(!member.getPassword().equals(configPassword)){
			return "member/signUpPasswordError";
		}
		String fileName = null;
		//사진이 들어갔는지 여부 검사
		if(photo.getSize() > 0){
			fileName = this.getNewFileName();
			String path = sc.getAttribute("rootRealPath") + "file/" + fileName;
			photo.transferTo(new File(path));
		}
		//사진이 없을경우 아에 member에 세팅하지 않아 null값이되도록한다
		if(fileName != null){
			member.setPhotos(new String[]{fileName});
		}
		memberService.signUp(member);

		model.addAttribute("myInfo", member);
		return "redirect:../main.do";
	}

	private String getNewFileName() {
		long millis = System.currentTimeMillis();
		if(currTime != millis){
			currTime = millis;
			count = 0;
		}
		return "member_"+millis+"_"+(++count);
	}

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signupForm() throws Exception {
		return "member/signupForm";
	}

}
