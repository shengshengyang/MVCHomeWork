package vegan.Dao.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import vegan.Dao.PostDao;
import vegan.model.Post;

@Repository
@Transactional
@EnableTransactionManagement
public class PostDaoImpl implements PostDao {

	@Autowired
	private SessionFactory sessionFactory;

	// 新增文章圖片測試
	public boolean addPostImage(Post post) {

		Session session = sessionFactory.getCurrentSession();
		session.save(post);
		return true;

	}

	// 刪除文章
	public boolean deletePost(int id) {

		Session session = sessionFactory.getCurrentSession();
		Post post = new Post();
		post.setPostId(id);
		session.delete(post);
		return true;

	}

	// 更新文章
	@Transactional
	public boolean updatePost(Post post) {

		Session session = sessionFactory.getCurrentSession();
		String hql = "UPDATE Post  set title= :title, postedText = :postedText, imgurl = :imgurl where postId = :postId ";
		int result = 0;
		result = session.createQuery(hql).setParameter("title", post.getTitle())
				.setParameter("postedText", post.getPostedText()).setParameter("imgurl", post.getImgurl())
				.setParameter("postId", post.getPostId()).executeUpdate();
		if (result > 0) {
			return true;
		} else {
			return false;
		}

	}

	// 搜尋一篇文章
	public Post findPost(int id) {

		Session session = sessionFactory.getCurrentSession();
		Post post = session.get(Post.class, id);
		return post;

	}

//搜尋全部

	public List<Post> findallPost() {

		List<Post> posts = null;
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Post order by postId desc";
		posts = session.createQuery(hql, Post.class).getResultList();

		return posts;

	}

}
