package gameUtils;



import classes.YatzyUser;
import gameClasses.Player;
import gameClasses.YatzyGame;
import utils.UserDAO;

public class YatzyService {


	
	private UserDAO userdao;
	private YatzyGameDAO gamedao;
	private PlayerDAO playerdao;

	public YatzyService() {
	}

	public YatzyService(UserDAO userdao, YatzyGameDAO gamedao, PlayerDAO playerdao) {
		this.userdao = userdao;
		this.gamedao = gamedao;
		this.playerdao = playerdao;
	}

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
		
		//TODO Update clients with YatzyGame as parameter
		

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

	public void poke(int gameId, String username) {
		YatzyGame game = gamedao.getGameById(gameId);
		game.poke(username);
	}

}
