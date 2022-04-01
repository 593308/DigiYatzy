package gameUtils;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import gameClasses.Player;
import gameClasses.PlayerId;

@Stateless
@LocalBean
public class PlayerDAO  {

    @PersistenceContext(name= "userDB")
    private EntityManager em; 


    public PlayerDAO() {

    }



    public List<Player> getAllPlayer() {

        return em.createQuery("SELECT s from Player s", Player.class).getResultList();
    }
    
    public List<Player> getPlayersByGameId(int gameId){
    	
    	TypedQuery<Player> q = em.createQuery("SELECT s from Player s where gameId = :gameId", Player.class); 
    	q.setParameter("gameId", gameId); 
    	
    	return q.getResultList(); 
    	
    }


  
    public void addNewPlayer(Player player) {

        em.persist(player);
    }

  
    public Player getPlayer(PlayerId id) {

        return em.find(Player.class, id); 

    }

//    /**
//     * 
//     * @param id - Sammensatt PK for å finne den riktig spilleren
//     * @param whatToUpdate - Hvilken verdi som skal oppdateres, enere, toere, treere osv..
//     */
//    public void updateScore(PlayerId id, String whatToUpdate, int value) {
//
//        Player x = getPlayer(id);
//        String userName = x.getYatzyUser().getUsername();
//        int gameId = x.getYatzyGame().getGameId(); 
//
//        TypedQuery<Player> q = em.createQuery("SELECT p from Player p where username = :userName AND gameid = :gameId ", Player.class);
//
//        q.setParameter("whatToUpdate", whatToUpdate); 
//        q.setParameter("userName", userName); 
//        q.setParameter("gameId", gameId); 
//
//        q.getSingleResult();
//        
//   
//
//
//
//
//
//    }
    
    public void updatePlayer(Player player) {
    	em.merge(player);
    }




}