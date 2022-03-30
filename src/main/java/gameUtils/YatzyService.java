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
	PlayerDAO playerdao; 
	
	
	public int createGame(String username) {
		YatzyGame game = new YatzyGame(username);
		return game.getGameId();
	}
	
	public void joinGame(int gameId, String username) {
		YatzyGame game = gamedao.getGameById(gameId);
		YatzyUser user = userdao.getUser(username);
		
		Player player = new Player(user, game);
		
		playerdao.addNewPlayer(player);
		
		
		
	}
	
	public void startGame(int gameId, String username) {
		
		YatzyGame game = gamedao.getGameById(gameId);
		game.startGame();
		gamedao.updateGame(game);
		
		
	}
	
	public void rollDice(int gameId, String username, boolean[] diceSelection) {
		YatzyGame game = gamedao.getGameById(gameId);
		rollDice(username, diceSelection);
	}
	
}
