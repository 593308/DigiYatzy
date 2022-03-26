package utils;

import java.util.List;

import classes.YatzyUser;

public interface DAO {
	
	public List<YatzyUser> getAllUsers();
	
	public void addNewUser(YatzyUser user);
	
	public YatzyUser getUser(String username);
	
	

}
