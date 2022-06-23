package vegan.Dao;

import java.util.List;

import vegan.model.User;

public interface UserDAO {
	
	public List <User> getUsers();

    public void saveUser(User theUser);

    public User getUser(Integer theId);

    public void deleteUser(Integer theId);
    
    public User login(String email, String password);

}
