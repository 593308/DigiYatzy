package utils;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import classes.YatzyUser;

@Stateless
@LocalBean
public class UserDAO implements DAO{
	
	@PersistenceContext(name = "userDB")
	private EntityManager em; 
	
	public UserDAO() {
		
	}
	


	@Override
	public List<YatzyUser> getAllUsers() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT s from yatzyUser s ", YatzyUser.class).getResultList();
	}

	@Override
	public void addNewUser(YatzyUser user) {
		// TODO Auto-generated method stub
		em.persist(user);
		
	}

	@Override
	public YatzyUser getUser(String username) {
		// TODO Auto-generated method stub
		return em.find(YatzyUser.class, username); 
	}

}
