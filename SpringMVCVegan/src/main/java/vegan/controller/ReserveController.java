package vegan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	 @GetMapping(value ="/reserves/{reserveId}",produces = { "application/json" })
	 @ResponseBody
	public ResponseEntity<Reserve> getReserve(@PathVariable (required = true) Integer reserveId){
		Reserve reserve = reserveService.getReserveById(reserveId);
	    
		if(reserve != null){
            return ResponseEntity.status(HttpStatus.OK).body(reserve);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
	}
	 
	 @GetMapping("/getReserves")
	 @ResponseBody
	 public List<Reserve> getAllReserves(){
		 List<Reserve> reserves = reserveService.reserveList();
		 return reserves;
	 }
	 
	 //改用 Ajax請求 新增資料
	@PostMapping(value = "/addReserve" , consumes = "application/json")
	public @ResponseBody Map<String, String> processAction(@RequestBody Reserve reserve) {
		Map<String, String> map = new HashMap<>();
		Integer reserveId = reserveService.insertReserve(reserve);
		
		Reserve checkReserve = reserveService.getReserveById(reserveId);
		
		if(checkReserve != null) {
			map.put("success", "新增成功");
		}else {
			map.put("fail", "新增失敗");
		}
		return map;
	}
	
	@DeleteMapping("/reserves/{reserveId}")
	public @ResponseBody ResponseEntity<Reserve> deleteReserve(@PathVariable(required = true) Integer reserveId) {
		reserveService.deleteReserveById(reserveId);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	//修改訂單
	 @PutMapping(value = "/reserves/{reserveId}", produces = { "application/json" })
		 public @ResponseBody ResponseEntity<Reserve> updateReserve(
					@RequestBody Reserve reserve,
					@PathVariable Integer reserveId) {
		 	Reserve checkReserve = null;
		 	
		 	if(reserveId != null) {
		 		checkReserve = reserveService.getReserveById(reserveId);
		 	}
		 	
	        if( checkReserve == null ) {
	        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	        	Reserve updateReserve = reserveService.updateReserve(reserveId,reserve);
	        return ResponseEntity.status(HttpStatus.OK).body(updateReserve);
	    }

	

}
