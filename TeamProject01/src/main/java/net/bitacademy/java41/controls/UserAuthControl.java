package net.bitacademy.java41.controls;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.service.AuthService;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller()
@SessionAttributes("myInfo")
@RequestMapping("/auth")
public class UserAuthControl{
	@Autowired AuthService authService;

	@RequestMapping("/login")
	public String longin(
			//파라미터로 넘어오는 이메일
			String email,
			//cookie에서 넘어오는 이메일
			@CookieValue(value="cookie_email",required=false) String cookie_email,
			String password,
			//saveId 체크시 on이라고 넘어온다
			String saveId,
			HttpServletResponse response,
			SessionStatus status,
			Model model) throws Exception {

		Member member = authService.getUserInfo(email, password);
		
		boolean isSaveId = false;
		
		if(saveId != null){
			//email값 받아올때 충돌 방지를 위해 cookie_email로 저장key바꿈
			Cookie cookie = new Cookie("cookie_email", email);
			//loginForm을 거치지않고 바로 login.do로 오므로 여기서도 isSaveId체크해줌
			isSaveId = true;
			//처음들어올경우는 cookie_email값이 없기때문에 if문으로 조건나눔
			if(cookie_email != null){//cookie_email이 존재할때
				model.addAttribute("cookie_email", cookie_email);
			} else {//아이디 저장체크는 되었는데 cookie 처음에 email이 존재하지않아 일단은 email값으로 세팅
				model.addAttribute("cookie_email", email);
			}
			model.addAttribute("isSaveId", isSaveId);
			cookie.setMaxAge(60);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("email", null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

		if( member != null){
			model.addAttribute("myInfo", member);
			if(member.getEmail().startsWith("admin"))
				return "redirect:../project/list.do";
			else
				return "redirect:../feed/listAll.do";
		} else {
			status.setComplete();
			return "auth/loginFail";
		}
	}

	@RequestMapping("/loginForm")
	public String loginForm(
			@CookieValue(value="cookie_email",required=false) String email,
			HttpSession session,
			Model model) {
		Member member = (Member)session.getAttribute("myInfo");
		if(member != null){
			return "redirect:../main.do";
		}

		boolean isSaveId = false;
		if(email != null){
			isSaveId = true;
		}
		model.addAttribute("email", email);
		model.addAttribute("isSaveId", isSaveId);

		return "auth/LoginForm";
	}

	@RequestMapping("/logout")
	public String logout(SessionStatus status) throws Exception {
		status.setComplete();
		return "redirect:loginForm.do";
	}
	@RequestMapping("/contactus")
	public String contactus() throws Exception {
		return "auth/contactus";
	}
}
