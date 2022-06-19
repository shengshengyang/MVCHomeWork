package vegan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vegan.model.Reserve;
import vegan.service.ReserveService;

@Controller
public class ReserveController {
	
	@Autowired
	private ReserveService reserveService;
	
	@GetMapping(path = "/reserve.controller")
	public String processMainAction(Model m) {
		Reserve r = new Reserve();
//		Members mem = new Members("lo","male",98);
//		m.addAttribute("members",mem);
		m.addAttribute("Reserve", r);
		return "reserve";
	}
	

	@PostMapping("/addReserve")
	public String processAction(@ModelAttribute("Reserve") Reserve r,
			BindingResult result,Model model) {
		if (result.hasErrors()) {
            return "error";
        }
		
		Integer reserveId = reserveService.insertReserve(r);
		Reserve reserve = reserveService.getReserveById(reserveId);
		
		model.addAttribute("Reserve",reserve);
		
		return "reserve";
	}
	
	 @GetMapping("/reserves/{reserveId}")
	public String getReserve(@PathVariable Integer reserveId , Model m){

	    Reserve reserve = reserveService.getReserveById(reserveId);
	    
	    
	    if(reserve != null) {
	    	m.addAttribute("Reserve",reserve);
	    }
	    
	    return "reserve";
	}
	

}
