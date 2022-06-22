package vegan.Dao.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vegan.Dao.ReserveDao;
import vegan.model.Reserve;

@Repository
@Transactional
public class ReserveDaoImpl implements ReserveDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer insertReserve(Reserve reserve) {
		Session session = sessionFactory.openSession();
		
		if(reserve != null) {
			session.save(reserve);
		}
		session.close();
		
		return reserve.getReserveId();
	}

	@Override
	public Reserve getReserveById(Integer reserveId) {
		Session session = sessionFactory.openSession();
		String hql = "from Reserve where id = :reserveId";
		Query<Reserve> query = session.createQuery(hql,Reserve.class);
		query.setParameter("reserveId",reserveId);
		
		Reserve reserve = query.uniqueResult();
		session.close();
		
		if(reserve != null) {
			return reserve;
		}
		
		return null;
	}

	@Override
	public List<Reserve> reserveList() {
		Session session = sessionFactory.openSession();
		List<Reserve> list = new ArrayList<Reserve>();
		
		String hql = "from Reserve";
		Query<Reserve> query = session.createQuery(hql,Reserve.class);
		list = query.getResultList();
		session.close();
		
		if(list != null) {
			return list;
		}
		
		return null;
	}

	@Override
	public void deleteReserveById(Integer reserveId) {
		Session session = sessionFactory.openSession();
		
		String hql = "delete from Reserve where id = :reserveId";
		
		Query<?> query = session.createQuery(hql);
		query.setParameter("reserveId", reserveId);
		
		session.beginTransaction();
		int executeUpdate = query.executeUpdate();
		if(executeUpdate >0) {
			session.getTransaction().commit();
		}
		
		session.close();
	}

	@Override
	public Reserve updateReserve(Integer reserveId, Reserve reserve) {
		Session session = sessionFactory.openSession();

		Reserve updateReserve = getReserveById(reserveId);
		
		updateReserve.setReserveId(reserveId);
		updateReserve.setReserveName(reserve.getReserveName());
		updateReserve.setReserveDate(reserve.getReserveDate());
		updateReserve.setReserveRestuarant(reserve.getReserveRestuarant());
		
		session.beginTransaction();
		session.update(updateReserve);
		session.getTransaction().commit();
		session.close();	
		
		return updateReserve;
	}

}
