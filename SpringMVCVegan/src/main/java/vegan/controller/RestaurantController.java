package vegan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vegan.model.Restaurant;
import vegan.service.RestaurantService;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	 @GetMapping("/restaurants")
	 public String getAllRestaurants(Model model){
		 List<Restaurant> restaurants = restaurantService.restaurantList();
		 model.addAttribute("restaurants", restaurants);
		 return "restaurantList";
	 }
	
	 @GetMapping("/restaurant/{restaurantNumber}")
	public String getRestaurant(@PathVariable Integer restaurantNumber , Model m){

		 Restaurant restaurant = restaurantService.getRestaurantByNumber(restaurantNumber);
	    
	    
	    if(restaurant != null) {
	    	m.addAttribute("Restaurant",restaurant);
	    }
	    
	    return "restaurantList";
	}
	 
	 @GetMapping("/showForm")
		public String showFormForAdd(Model model) {
		 Restaurant restaurant = new Restaurant();
			model.addAttribute("restaurant", restaurant);

			return "restaurantForm";
		}
	 
		@GetMapping("/updateRestaurant")
		public String updateRestaurant(@RequestParam("restaurantNumber") Integer restaurantNumber, Model model) {
			Restaurant restaurant = restaurantService.getRestaurantByNumber(restaurantNumber);
			model.addAttribute("restaurant", restaurant);

			return "restaurantForm";
		}
	
	 @PostMapping("/saveRestaurant")
		public String saveRestaurant(@ModelAttribute("restaurant") Restaurant restaurant) {
			restaurantService.saveRestaurant(restaurant);

			return "redirect:/restaurant/restaurants";
		}
	 
	 
	 @GetMapping("/delete")
	public String deleteRestaurant(@RequestParam("restaurantNumber")  Integer restaurantNumber) {
		restaurantService.deleteRestaurantByNumber(restaurantNumber);
		
		return "redirect:/restaurant/restaurants";
	}
	 
	 @GetMapping("/index")
	 public String back() {
		 return "veganIndex";
	 }

}
