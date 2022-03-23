package utils;

import java.util.List;

import classes.User;

public interface DAO {
	
	public List<User> getAllUsers();
	
	public void addNewUser(User user);
	
	public User getUser(String username);
	
	

}
