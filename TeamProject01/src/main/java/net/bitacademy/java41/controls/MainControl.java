package net.bitacademy.java41.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainControl{

	@RequestMapping
	public String execute() throws Exception {
		return "main";
	}

}












