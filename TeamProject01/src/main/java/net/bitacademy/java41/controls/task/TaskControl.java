package net.bitacademy.java41.controls.task;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import net.bitacademy.java41.service.ProjectService;
import net.bitacademy.java41.service.TaskService;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SessionAttributes("task")
@RequestMapping("/task")
public class TaskControl{
	@Autowired TaskService taskService;
	@Autowired ProjectService projectService;
	@Autowired ServletContext sc;
	long currTime = 0;
	int count = 0;

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addForm(Model model, int projectNo) throws Exception {
		model.addAttribute("projectNo",projectNo);
		return "task/addForm";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(
			Task task,
			MultipartFile URL, 
			int projectNo) throws Exception {
		String fileName = this.getNewFileName();
		String path = sc.getAttribute("rootRealPath") + "file/" + fileName;
		URL.transferTo(new File(path));
		
		taskService.addTask(task.setUiProtoUrl(fileName));
		
		return "redirect:list.do?projectNo="+projectNo;
	}

	@RequestMapping("/delete")
	public String delete(int projectNo, int taskNo) throws Exception {
		
		taskService.removeTask(taskNo);
		return "redirect:../task/list.do?projectNo="+projectNo;
	}
	
	@RequestMapping("/list")
	public String list(int projectNo, Model model) throws Exception {
		
		List<Task> list = taskService.getTaskList(projectNo);
		
		model.addAttribute("taskList", list);
		model.addAttribute("no", projectNo);
		return "task/list";
		
	}
	
	@RequestMapping("/listAll")
	public String listAll(Model model) throws Exception {
		
		List<Task> list = taskService.taskAllList();
		model.addAttribute("taskAllList", list);
		return "task/listAll";
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(
			Task task, 
			MultipartFile URL, 
			Model model,
			int taskNo) throws Exception {
		String fileName = this.getNewFileName();
		String path = sc.getAttribute("rootRealPath") + "file/" + fileName;
		URL.transferTo(new File(path));
		model.addAttribute("uiProtoUrl", URL);
		task.setUiProtoUrl(fileName);
		taskService.updateTask(task);
		model.addAttribute("task", task);
		
		return "redirect:view.do?no="+taskNo;
	}

	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateForm(Model model, int taskNo) throws Exception {
		model.addAttribute("taskNo", taskNo);
		model.addAttribute("task", taskService.getTask(taskNo));
		return "task/updateForm";
	}

	@RequestMapping("/view")
	public String view(int no, Model model, @ModelAttribute("myInfo")Member member) throws Exception {
		Task t = taskService.getTask(no);
		model.addAttribute("isMyProject", projectService.isMyProject(member, t.getProjectNo()));
		model.addAttribute("task", t);
		return "task/view";
	}

	private String getNewFileName() {
		long millis = System.currentTimeMillis();
		if(currTime != millis){
			currTime = millis;
			count = 0;
		}
		return "task"+millis+"_"+(++count);
	}
	
}