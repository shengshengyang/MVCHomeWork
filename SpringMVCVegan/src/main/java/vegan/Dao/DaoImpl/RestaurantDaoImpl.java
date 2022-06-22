package vegan.Dao.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vegan.Dao.RestaurantDao;
import vegan.model.Restaurant;

@Repository
@Transactional
public class RestaurantDaoImpl implements RestaurantDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Restaurant> restaurantList() {
		Session session = sessionFactory.openSession();
		List<Restaurant> list = new ArrayList<Restaurant>();
		
		String hql = "from Restaurant";
		Query<Restaurant> query = session.createQuery(hql, Restaurant.class);
		list = query.getResultList();
		session.close();
		
		if (list != null) {
//			System.out.println("1");
//			for (Restaurant restaurant : list) {
//				System.out.println(restaurant.getRestaurantName());
//			}
			return list;
		}
//		System.out.println("2");
		return null;
	}
	
	@Override
	public Restaurant getRestaurantByNumber(Integer restaurantNumber) {
		Session session = sessionFactory.openSession();
		String hql = "from Restaurant where restaurantNumber = :restaurantNumber";
		Query<Restaurant> query = session.createQuery(hql,Restaurant.class);
		query.setParameter("restaurantNumber",restaurantNumber);
		
		Restaurant restaurant = query.uniqueResult();
		session.close();
		
		if(restaurant != null) {
			return restaurant;
		}
		
		return null;
	}

	@Override
	public void saveRestaurant(Restaurant restaurant) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(restaurant);
	}

	@Override
	public void deleteRestaurantByNumber(Integer restaurantNumber) {
		Session session = sessionFactory.getCurrentSession();
		Restaurant restaurant = session.byId(Restaurant.class).load(restaurantNumber);
		session.delete(restaurant);
	}

}
