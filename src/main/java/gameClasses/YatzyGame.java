package gameClasses;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import gameUtils.GameState;

@Entity
@Table(schema = "yatzy")
public class YatzyGame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gameId;

	private String hostPlayer;

	@OneToMany(mappedBy = "yatzyGame")
	private List<Player> players;

	private int eventCounter;
	private GameState gameState;
	private int roundCount;
	private String currentPlayer;
	private int diceRollCount;
	private int strikeCount;
	private int die0Value;
	private int die1Value;
	private int die2Value;
	private int die3Value;
	private int die4Value;

//	private Die[] dice;

	public YatzyGame(String hostPlayer) {
		this.hostPlayer = hostPlayer;
		eventCounter = 0;
		gameState = GameState.PLAYER_JOIN;
		roundCount = 0;
		currentPlayer = null;
		diceRollCount = 0;
		strikeCount = 0;
		die0Value = 0;
		die1Value = 0;
		die2Value = 0;
		die3Value = 0;
		die4Value = 0;

//		for (int i = 0; i < 5; i++)
//			dice[i] = new Die(i);
		
//		dice = null;

	}
	
	public YatzyGame() {
		
	}
	
	public int getGameId() {
		return gameId;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}
	
	public void startGame() {
		
		currentPlayer = hostPlayer; 
		roundCount = 1; 
		gameState = GameState.PLAYER_TURN;
		
	}
	
	public void rollDice(String username, boolean[] diceselection) {
		
		List<Integer> dice = new ArrayList<Integer>();
		
		dice.add(die0Value);
		dice.add(die1Value);
		dice.add(die2Value);
		dice.add(die3Value);
		dice.add(die4Value);
		
		dice.stream().forEach(x -> x = (int) ((Math.random() *5) + 1));
		
		for (int i = 0; i < diceselection.length; i++) {
			if (diceselection[i]) {
				
			}
		}
		
	}

}
