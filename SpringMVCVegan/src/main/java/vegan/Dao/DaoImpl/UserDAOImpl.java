package vegan.Dao.DaoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vegan.Dao.UserDAO;
import vegan.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery <User> cq = cb.createQuery(User.class);
        Root <User> root = cq.from(User.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
	}

	@Override
	public void saveUser(User theUser) {
		Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theUser);
	}

	@Override
	public User getUser(Integer theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		User theUser = currentSession.get(User.class, theId);
        return theUser;
	}

	@Override
	public void deleteUser(Integer theId) {
		Session session = sessionFactory.getCurrentSession();
		User theUser = session.byId(User.class).load(theId);
        session.delete(theUser);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public User login(String email, String password) {

		User user = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM User u WHERE u.email = :email AND u.password = :password";

		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		user = (User) query.uniqueResult();

		return user;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean isEmailExist(String email) {
		
		User user = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM User u WHERE u.email = :email";

		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		user = (User) query.uniqueResult();

		if (user != null) {
			return true;
		} else {
			return false;
		}
		
	}

}
