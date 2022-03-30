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
	
//	public byte[] poll(int gameId, int eventCounter) {
//		YatzyGame game = gamedao.getGameById(gameId);
//		
//		if (eventCounter == game.getEventCounter()) 
//			return null;
//		
//		return game.marshall();
//		
//	}
	
	
	public int createGame(String username) {
		YatzyGame game = new YatzyGame(username);
		
		
		
		gamedao.createGame(game);
		
		
		joinGame(game.getGameId(), username);
		
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
		game.rollDice(username, diceSelection);
		
		gamedao.updateGame(game);
	}
	
	public void endTurn(int gameId, String username) {
		YatzyGame game = gamedao.getGameById(gameId);
		game.endTurn(username);
	}
	
}
