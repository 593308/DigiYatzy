package gameUtils;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gameClasses.YatzyGame;

@Stateless
@LocalBean
public class YatzyGameDAO {
	
	@PersistenceContext(name = "userDB")
	private EntityManager em;
	
	public YatzyGameDAO() {
		
	}
	
	public List<YatzyGame> getAllGames() {
		return em.createQuery("SELECT g from yatzyGame g ", YatzyGame.class).getResultList();
	}
	
	public void newGame(YatzyGame game) {
		em.persist(game);
	}
	
	public YatzyGame getGameById(int gameId) {
		return em.find(YatzyGame.class, gameId);
	}

}
