package gameUtils;

import java.util.HashMap;

import classes.YatzyUser;
import gameClasses.Player;
import gameClasses.YatzyGame;
import utils.UserDAO;

public class YatzyService {

	private HashMap<Integer, YatzyGame> activeGames;
	UserDAO userdao;
	YatzyGameDAO gamedao;
	
	public int createGame(String username) {
		YatzyGame game = new YatzyGame(username);
		return game.getGameId();
	}
	
	public void joinGame(int gameId, String username) {
		YatzyGame game = gamedao.getGameById(gameId);
		YatzyUser user = userdao.getUser(username);
		
		Player player = new Player(user, game);
		
		game.addPlayer(player);
		
		
		
		
		
		
	}
	
}
