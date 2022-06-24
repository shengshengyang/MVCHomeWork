package vegan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vegan.model.User;
import vegan.service.UserService;

@Controller
//@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@GetMapping("/user/list")
    public String listCustomers(Model m) {
        List <User> theUsers = userService.getUsers();
        m.addAttribute("users", theUsers);
        return "list-users";
    }
	
	@GetMapping("/user/showForm")
    public String showFormForAdd(Model m) {
		User theUser = new User();
        m.addAttribute("user", theUser);
        return "user-form";
    }

    @PostMapping("/user/saveUser")
    public String saveCustomer(@Valid @ModelAttribute("user") User theUser, BindingResult result, HttpSession session, Model m) {
    	
    	String theCheckEmail = (String) session.getAttribute("checkmail");
    	
    	Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		boolean isEmailExist = userService.isEmailExist(theUser.getEmail());
		
		if(!theUser.getEmail().equals(theCheckEmail)) {
			if(isEmailExist) {
				errors.put("msg", "此Email已存在,請更換");
				return "user-form";
			}			
		}
		
    	System.out.println(theUser.getEmail());
    	
    	if(result.hasErrors()) {
    		return "user-form";
    	}
    	
    	userService.saveUser(theUser);
    	session.removeAttribute("checkmail");
        return "redirect:/user/list";
    }

    @GetMapping("/user/updateForm")
    public String showFormForUpdate(HttpSession session, @RequestParam("userId") Integer theId,
        Model m) {
        User theUser = userService.getUser(theId);
        m.addAttribute("user", theUser);
        String checkEmail = theUser.getEmail();
        session.setAttribute("checkmail", checkEmail);
        return "user-form";
    }

    @GetMapping("/user/delete")
    public String deleteUser(@RequestParam("userId") Integer theId) {
    	userService.deleteUser(theId);
        return "redirect:/user/list";
    }
        
    @RequestMapping("/user/goLogin")
	public String login() {
		return "login";
	}
    
    @RequestMapping("/user/login")
	public String processAction(HttpSession session, String email, String password, Model m) {
    	Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		if(email==null || email.length()==0) {
			errors.put("name", "請輸入email");
		}
		
		if(password==null || password.length()==0) {
			errors.put("pwd", "請輸入密碼");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "login";
		}
		
		User result = new User();
		
		result = userService.login(email, password);
		
		if(result != null) {
			String username = result.getUsername();
			session.setAttribute("userLoginInfo", username);
			m.addAttribute("username", username);
			
			return "loginSuccess";
		}
		
		errors.put("msg", "帳號密碼錯誤");
		return "login";
	}
    
    @RequestMapping("/logout")
	public String logout(HttpSession session) {
    	session.removeAttribute("userLoginInfo");
		return "veganIndex";
	}

}
