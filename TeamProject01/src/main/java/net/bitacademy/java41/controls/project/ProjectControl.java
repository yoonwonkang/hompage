package net.bitacademy.java41.controls.project;

import net.bitacademy.java41.service.ProjectService;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("myInfo")
@RequestMapping("/project")
public class ProjectControl {
	@Autowired ProjectService projectService;

	@RequestMapping("/list2")
	public String list2(Model model) throws Exception {
		model.addAttribute("list", projectService.getProjectList());
		return "project/list";
	}
	
	@RequestMapping("/list")
	public ModelAndView list() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("project/list");
		mv.addObject("list", projectService.getProjectList());
		return mv;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String form() {
		return "project/newForm";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(
			Project project,
			@ModelAttribute("myInfo") Member member) throws Exception {
		System.out.println(member.getEmail());
		project.setLeader(member.getEmail());
		projectService.addProject(project);
		return "redirect:list.do";
	}
	
	@RequestMapping("/view")
	public String view(
			int no, 
			Model model, 
			@ModelAttribute("myInfo") Member member) throws Exception {
		model.addAttribute("project", projectService.getProject(no));
		model.addAttribute("projectMember", projectService.listByProjectMember(no));
		model.addAttribute("isMyProject", projectService.isMyProject(member, no));
		/* 이 프로젝트가 내 프로젝트인지 물어보는 메소드 만약 맞다면 */
		if(projectService.isMyProject(member, no)){
			/*그 프로젝트를 통해 이 프로젝트에서의 나의 레벨을 물어보는 것*/
			model.addAttribute("projectLeader", projectService.getProjectLevel(member.getEmail(), no));
		}
		return "project/view";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateForm(int no, Model model) throws Exception {
		model.addAttribute("project", projectService.getProject(no));
		return "project/updateForm";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Project project) throws Exception {
		projectService.updateProject(project);
		return "redirect:view.do?no=" + project.getNo();
	}
	
	@RequestMapping("/delete")
	public String delete(int no) throws Exception {
		projectService.deleteProject(no);
		return "redirect:list.do";
	}
}













