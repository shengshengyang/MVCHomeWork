package vegan.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vegan.Dao.RestaurantDao;
import vegan.model.Restaurant;
import vegan.service.RestaurantService;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDao restaurantDao;

	@Override
	public List<Restaurant> restaurantList() {
		return restaurantDao.restaurantList();
	}
	
	@Override
	public Restaurant getRestaurantByNumber(Integer restaurantNumber) {
		return restaurantDao.getRestaurantByNumber(restaurantNumber);
	}


	@Override
	public void saveRestaurant(Restaurant restaurant) {
		restaurantDao.saveRestaurant(restaurant);
	}

	@Override
	public void deleteRestaurantByNumber(Integer restaurantNumber) {
		restaurantDao.deleteRestaurantByNumber(restaurantNumber);
	}

}
