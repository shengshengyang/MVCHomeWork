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
		
		String hql = "from Reserve where id = :reserveId";
		
		Query<Reserve> query = session.createQuery(hql,Reserve.class);
		query.setParameter("reserveId", reserveId);
		
		Reserve reserve = query.uniqueResult();
		
		if(reserve != null) {
		session.delete(session);
		System.out.println("Already Delete Reserve Object "+ reserveId);
		
		}
	}

	@Override
	public Reserve updateReserve(Integer reserveId, Reserve reserve) {
		Session session = sessionFactory.openSession();
		
		String hql = "update Reserve r set "
				+ "r.reserveName=:reserveName and"
				+ " r.reserveDate=:reserveDate and"
				+ " r.reserveRestuarant=:reserveRestuarant"
				+ " where r.reserveId= :reserveId";
		
		Query<Reserve> query = session.createQuery(hql,Reserve.class);
		
		query.setParameter("reserveName" ,reserve.getReserveName());
		query.setParameter("reserveDate" ,reserve.getReserveDate());
		query.setParameter("reserveRestuarant" ,reserve.getReserveRestuarant());
		query.setParameter("reserveId" ,reserveId);
		
		Reserve updateReserve =  query.uniqueResult();
		
		if(updateReserve != null ) {
			return updateReserve;
		}
		
		return null;
	}

}
