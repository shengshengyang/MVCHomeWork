package vegan.Dao;

import java.util.List;

import vegan.model.Restaurant;

public interface RestaurantDao {
	public List<Restaurant> restaurantList();
	public Restaurant getRestaurantByNumber(Integer restaurantNumber);
	public void saveRestaurant(Restaurant restaurant);
	public void deleteRestaurantByNumber(Integer restaurantNumber);
}
