package vegan.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vegan.Dao.ForumDao;
import vegan.model.Forum;
import vegan.service.ForumService;

@Service
@Transactional
public class ForumServiceImpl implements ForumService {
	
	@Autowired
	private ForumDao forumDao;

	@Override
	public List<Forum> getForums() {	
		return forumDao.getForums();
	}

	@Override
	public void saveForum(Forum forum) {
		 forumDao.saveForum(forum);
	}

	 public List<Forum> list() {
	      return forumDao.list();
	   }

	@Override
	public void updateForum(Forum forum) {
		forumDao.updateForum(forum);
		
	}

	@Override
	public void deleteForumByPrimaryKey(int key) {
		forumDao.deleteForumByPrimaryKey(key);
		
	}

	@Override
	public Forum getForumById(int id) {
		forumDao.getForumById(id);
		return null;
	}

}
