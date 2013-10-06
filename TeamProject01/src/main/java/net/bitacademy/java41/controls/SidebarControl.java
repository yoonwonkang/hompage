package net.bitacademy.java41.controls;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.service.ProjectService;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SidebarControl {
	@Autowired ProjectService projectService;
	@RequestMapping("/sidebar")
	public String execute(
			HttpSession session,
			Model model) throws Exception {

		Member member = (Member)session.getAttribute("myInfo");
		System.out.println(member.getEmail());
		int listSize = projectService.getMyProjects(member.getEmail()).size();
		model.addAttribute("myprojects", projectService.getMyProjects(member.getEmail()));
		model.addAttribute("listSize", listSize);
		return "sidebar";
	}
}