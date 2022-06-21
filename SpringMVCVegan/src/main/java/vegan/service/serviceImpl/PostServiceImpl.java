package vegan.service.serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vegan.Dao.PostDao;
import vegan.model.Post;
import vegan.service.PostService;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;

	public boolean addPostImage(Post post) {
		return postDao.addPostImage(post);

	}

	@Transactional
	public boolean deletePost(int id) {
		return postDao.deletePost(id);

	}

	@Transactional
	public boolean updatePost(Post post) {
		return postDao.updatePost(post);

	}

	public Post findPost(int id) {
		return postDao.findPost(id);
	}

	public List<Post> findallPost() {
		return postDao.findallPost();

	}

}
