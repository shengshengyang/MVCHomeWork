package vegan.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vegan.model.Forum;
import vegan.service.ForumService;

@Controller
public class ForumController {

	@Autowired
	private ForumService forumService;
	
	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public String listForum( Model model) {
		List<Forum> forums = forumService.getForums();
		model.addAttribute("forums",forums);
		return "forum";
	}
	
	@GetMapping("/insert")
	public String insert() {
			return "addforum";
		}
	
	@GetMapping("/add.controller")
	public String saveForum (@ModelAttribute("forum") Forum forum, BindingResult result, Model model) {
			if(result.hasErrors()) {
				model.addAttribute("forums", forumService.list());
				return "editForum";
			}
			forumService.saveForum(forum);
			return "redirect:list";
		}

	@GetMapping(value="/list/{id}")
	public String deleteForumById(@PathVariable Integer id) {
		System.out.println(11122233);
		forumService.deleteForumByPrimaryKey(id);	
		return "success";
	}
	

	
	@GetMapping("/edit/{id}")
	public String editForumById(Model model, @PathVariable Integer id , @ModelAttribute("forum")Forum forum) {
		 forum = forumService.getForumById(id);
		 model.addAttribute("forum", forum);
		 return "editforum";
	}
	
	@GetMapping("/edit")
	public String updateforum( @ModelAttribute("forum")Forum forum , Model model) {
		  forumService.updateForum(forum);
		return "success";
		
	}

	

	
	
}
