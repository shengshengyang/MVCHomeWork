package vegan.service;

import java.util.List;

import vegan.model.User;

public interface UserService {
	
	public List <User> getUsers();

    public void saveUser(User theUser);

    public User getUser(Integer theId);

    public void deleteUser(Integer theId);

}
