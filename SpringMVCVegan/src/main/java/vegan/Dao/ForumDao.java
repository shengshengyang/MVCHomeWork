package vegan.Dao;

import java.util.List;

import vegan.model.Forum;

public interface ForumDao {
	public List<Forum> getForums();
	
	public void saveForum (Forum forum);

	public List<Forum> list();
	
	void updateForum(Forum forum); 

	void deleteForumByPrimaryKey(int key);
	
	public Forum getForumById(int id);
}
