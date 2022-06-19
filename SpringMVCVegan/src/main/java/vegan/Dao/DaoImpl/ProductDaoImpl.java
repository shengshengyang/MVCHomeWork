package vegan.Dao.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vegan.Dao.ProductDao;
import vegan.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProduct() {
		Session session = sessionFactory.openSession();
		List<Product> list = new ArrayList<Product>();

		String hql = "from Product";
		Query<Product> query = session.createQuery(hql, Product.class);
		list = query.getResultList();
		session.close();

		if (list != null) {
			return list;
		}

		return null;
	}

	@Override
	public Product getProductById(Integer productId) {
		Session session = sessionFactory.openSession();
		String hql = "from Product where id = :productId";
		Query<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("productId", productId);

		Product product = query.uniqueResult();
		session.close();

		if (product != null) {
			return product;
		}

		return null;
	}

	@Override
	public void saveProduct(Product product) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(product);

	}

	@Override
	public void deleteProduct(Integer productId) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.byId(Product.class).load(productId);
		session.delete(product);

	}

}
