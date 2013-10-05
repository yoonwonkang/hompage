package net.bitacademy.java41.controls.feed;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.service.FeedService;
import net.bitacademy.java41.service.MemberService;
import net.bitacademy.java41.vo.Feed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("feed")
@RequestMapping("/feed")
public class FeedControl {
	@Autowired	FeedService feedService;
	@Autowired	ServletContext sc;
	@Autowired MemberService memberService;
	long currTime = 0;
	int count = 0;
	boolean listAllOn = false;

	// @RequestMapping(value="/add", method=RequestMethod.GET)
	// public String addForm(Model model, int projectNo) throws Exception {
	// model.addAttribute("projectNo",projectNo);
	// return "feed/addForm";
	// }
	//
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Feed feed, Model model) throws Exception {
		String replacedCont = feed.getContent().replace("\r\n", "<br>");
		feed.setContent(replacedCont);
		List<Feed> list = feedService.getFeedList(feed.getProjectNo());
		if (list.size() > 0) {
			model.addAttribute("feedList", list);
			model.addAttribute("no", feed.getProjectNo());
		}
		feedService.addFeed(feed);
		return "redirect:list.do?projectNo=" + feed.getProjectNo();
	}

	@RequestMapping("/delete")
	public String delete(int fno) throws Exception {
		Feed feed = feedService.getFeed(fno);
		int temp = feed.getProjectNo();
		feedService.removeFeed(fno);
		if (listAllOn) {
			return "redirect:listAll.do";
		} else {
			return "redirect:list.do?projectNo=" + temp;
		}
	}

	@RequestMapping("/list")
	public String list(int projectNo, String email, Model model,
			HttpSession session) throws Exception {

		List<Feed> list = feedService.getFeedList(projectNo);
		model.addAttribute("photoList", memberService.getAllPhoto());
		model.addAttribute("feedList", list);
		model.addAttribute("no", projectNo);
		listAllOn = false;
		return "feed/list";

	}

	@RequestMapping("/listAll")
	public String listAll(Model model, String email) throws Exception {

		List<Feed> list = feedService.getFeedAllList();
		model.addAttribute("photoList", memberService.getAllPhoto());
		model.addAttribute("feedAllList", list);
		listAllOn = true;
		return "feed/listAll";
	}

	// @RequestMapping(value="/update", method=RequestMethod.POST)
	// public String update(
	// Feed feed,
	// MultipartFile URL,
	// Model model,
	// int feedNo) throws Exception {
	// String fileName = this.getNewFileName();
	// String path = sc.getAttribute("rootRealPath") + "file/" + fileName;
	// URL.transferTo(new File(path));
	// model.addAttribute("uiProtoUrl", URL);
	// //feed.setUiProtoUrl(fileName);
	// feedService.updateFeed(feed);
	// model.addAttribute("feed", feed);
	//
	// return "redirect:view.do?no="+feedNo;
	// }
	//
	// @RequestMapping(value="/update", method=RequestMethod.GET)
	// public String updateForm(Model model, int feedNo) throws Exception {
	// model.addAttribute("feedNo", feedNo);
	// //model.addAttribute("feed", feedService.getFeed(feedNo));
	// return "feed/updateForm";
	// }
	//
	// private String getNewFileName() {
	// long millis = System.currentTimeMillis();
	// if(currTime != millis){
	// currTime = millis;
	// count = 0;
	// }
	// return "feed"+millis+"_"+(++count);
	// }

}