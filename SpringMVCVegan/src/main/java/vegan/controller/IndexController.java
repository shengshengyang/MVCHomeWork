package vegan.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes(names = {"login"})
public class IndexController {
	
	@RequestMapping(path="index" ,
					method = RequestMethod.GET)
	public String processIndexAction(Model m, SessionStatus status) {
		
		Map<String,String> loginStatus = new HashMap<String,String>();
		m.addAttribute("login", loginStatus);
		
		loginStatus.put("status", "您好，您尚未登入，不可進行登入以外的操作");
		
		status.setComplete();
		
		return "veganIndex";
	}

}
