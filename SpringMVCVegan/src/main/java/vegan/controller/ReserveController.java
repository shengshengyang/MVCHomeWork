package vegan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Reserve getReserve(@PathVariable (required = true) Integer reserveId){
		Reserve reserve = reserveService.getReserveById(reserveId);
	    
	    return reserve;
	}
	 
	 @GetMapping("/getReserves")
	 @ResponseBody
	 public List<Reserve> getAllReserves(){
		 List<Reserve> reserves = reserveService.reserveList();
		 return reserves;
	 }
	 
	 @GetMapping(value = "/reserveEdit/{reserveId}", produces = { "application/json" })
	 @ResponseBody
	 public String editReserveFindView(@PathVariable Integer reserveId, Model model){
		 model.addAttribute("pk", reserveId);
		 return "updateReserve";
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
	public @ResponseBody Map<String, String> deleteReserve(@PathVariable(required = true) Integer reserveId) {
		Map<String, String> map = new HashMap<>();
		
		try {
		reserveService.deleteReserveById(reserveId);
		map.put("success", "刪除成功");
		}catch (Exception e) {
			e.printStackTrace();
			map.put("fail", "刪除失敗");
			System.out.println("刪除失敗");
		}
		return map;
	}
	
	//修改訂單
	 @PutMapping(value = "/reserves/{reserveId}", consumes = { "application/json" }, produces = { "application/json" })
		 public @ResponseBody Map<String, String> updateReserve(
					@RequestBody Reserve reserve,
					@PathVariable Integer reserveId) {
		 	Reserve checkReserve = null;
		 	if(reserveId != null) {
		 		checkReserve = reserveService.getReserveById(reserveId);
		 	}
	        if( checkReserve == null ) {
	            throw new RuntimeException("查詢訂單編號不存在, Id=" + reserveId);
	        }
	        Map<String, String> map = new HashMap<>();
	        try {
	        	reserveService.updateReserve(reserveId,reserve);
	        	map.put("success", "更新成功");
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	map.put("fail", "更新失敗");
			}
	        return map;
	    }

	

}
