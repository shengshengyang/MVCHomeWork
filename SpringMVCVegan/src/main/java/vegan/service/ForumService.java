package vegan.service;

import java.util.List;

import vegan.model.Forum;

public interface ForumService {
	
	 List<Forum> list();
	
	public List<Forum> getForums();
	
	public void saveForum (Forum forum);
	
	void updateForum(Forum forum); 

	void deleteForumByPrimaryKey(int key);
	
	public Forum getForumById(int id);
}
