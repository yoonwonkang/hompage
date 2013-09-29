package net.bitacademy.java41.controls.task;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.service.TaskService;
import net.bitacademy.java41.vo.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/task")
public class TaskControl{
	@Autowired TaskService taskService;
	@Autowired ServletContext sc;
	long currTime = 0;
	int count = 0;

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addForm(Model model, int projectNo) throws Exception {
		model.addAttribute("projectNo",projectNo);
		System.out.println("addform jsp로");
		return "/task/addForm.jsp";
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
		return "/task/list.jsp";
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(
			Task task, 
			MultipartFile URL, 
			HttpSession session, 
			Model model,
			int taskNo) throws Exception {
		String fileName = this.getNewFileName();
		String path = sc.getAttribute("rootRealPath") + "file/" + fileName;
		URL.transferTo(new File(path));
		model.addAttribute("uiProtoUrl", URL);
		task.setUiProtoUrl(fileName);
		taskService.updateTask(task);
		session.setAttribute("task", task);
		
		return "redirect:view.do?no="+taskNo;
	}

	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateForm(Model model, int taskNo) throws Exception {
		model.addAttribute("taskNo", taskNo);
		model.addAttribute("task", taskService.getTask(taskNo));
		return "/task/updateForm.jsp";
	}

	@RequestMapping("/view")
	public String view(HttpSession session, int no) throws Exception {
		Task t = taskService.getTask(no);
		session.setAttribute("task", t);
		return "/task/view.jsp";
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