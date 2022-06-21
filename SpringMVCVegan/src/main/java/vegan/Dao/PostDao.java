package vegan.Dao;

import java.util.List;

import vegan.model.Post;


public interface PostDao {

	boolean addPostImage(Post post);
	
	boolean deletePost(int id);
	
	public boolean updatePost(Post post);
	
	public Post findPost(int id);
	
	public List<Post> findallPost();
	
}
