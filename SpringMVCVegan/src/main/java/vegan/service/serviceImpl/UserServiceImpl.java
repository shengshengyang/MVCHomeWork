package vegan.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vegan.Dao.UserDAO;
import vegan.model.User;
import vegan.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserDAO userDAO;

	@Override
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	public void saveUser(User theUser) {
		userDAO.saveUser(theUser);
	}

	@Override
	public User getUser(Integer theId) {
		return userDAO.getUser(theId);
	}

	@Override
	public void deleteUser(Integer theId) {
		userDAO.deleteUser(theId);
	}

	@Override
	public User login(String email, String password) {
		return userDAO.login(email, password);
	}

	@Override
	public boolean isEmailExist(String email) {
		return userDAO.isEmailExist(email);
	}

}
