package vegan.controller;

import java.util.List;

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
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@GetMapping("/list")
    public String listCustomers(Model m) {
        List <User> theUsers = userService.getUsers();
        m.addAttribute("users", theUsers);
        return "list-users";
    }
	
	@GetMapping("/showForm")
    public String showFormForAdd(Model m) {
		User theUser = new User();
        m.addAttribute("user", theUser);
        return "user-form";
    }

    @PostMapping("/saveUser")
    public String saveCustomer(@Valid @ModelAttribute("user") User theUser, BindingResult result) {
    	
    	if(result.hasErrors()) {
    		return "user-form";
    	}
    	
    	userService.saveUser(theUser);
        return "redirect:/user/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("userId") Integer theId,
        Model m) {
        User theUser = userService.getUser(theId);
        m.addAttribute("user", theUser);
        return "user-form";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") Integer theId) {
    	userService.deleteUser(theId);
        return "redirect:/user/list";
    }

}
