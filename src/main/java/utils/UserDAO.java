package utils;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import classes.User;

@Stateless
public class UserDAO implements DAO{
	
	private EntityManager em; 
	


	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT s from users s ", User.class).getResultList();
	}

	@Override
	public void addNewUser(User user) {
		// TODO Auto-generated method stub
		em.persist(user);
		
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return em.find(User.class, username); 
	}

}
