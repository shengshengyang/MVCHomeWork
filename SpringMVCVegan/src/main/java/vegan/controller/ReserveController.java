package vegan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	
	 @GetMapping("/reserves/{reserveId}")
	public String getReserve(@PathVariable Integer reserveId , Model m){

	    Reserve reserve = reserveService.getReserveById(reserveId);
	    
	    
	    if(reserve != null) {
	    	m.addAttribute("Reserve",reserve);
	    }
	    
	    return "reserve";
	}
	 
	 @GetMapping("/getReserves")
	 @ResponseBody
	 public List<Reserve> getAllReserves(){
		 List<Reserve> reserves = reserveService.reserveList();
		 return reserves;
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
	
	@DeleteMapping("/reserves/{reserveId}")
	public String deleteReserve(@PathVariable Integer reserveId) {
		reserveService.deleteReserveById(reserveId);
		
		return "reserve";
	}
	

	 
	 @PutMapping("/products/{productId}")
	 public String updateReserve(@PathVariable Integer reserveId,Reserve reserve){
	        Reserve checkReserve = reserveService.getReserveById(reserveId);
	        if( checkReserve == null ) {
	            return "error";
	        }

	        reserveService.updateReserve(reserveId,reserve);

	        Reserve updateReserve = reserveService.getReserveById(reserveId);

	        return "reserve";
	    }

	

}
