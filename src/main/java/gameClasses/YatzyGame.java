package gameClasses;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import gameUtils.GameState;
import gameUtils.PlayerState;

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

	

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public void startGame() {

		currentPlayer = players.get(0).getYatzyUser().getUsername();
		roundCount = 1;
		gameState = GameState.PLAYER_TURN;

	}

	public void rollDice(String username, boolean[] diceselection) {

//		List<Integer> dice = new ArrayList<Integer>();
//		
//		dice.add(die0Value);
//		dice.add(die1Value);
//		dice.add(die2Value);
//		dice.add(die3Value);
//		dice.add(die4Value);
//		
//		dice.stream().forEach(x -> x = (int) ((Math.random() *5) + 1));
		
		currentPlayer = username;

		if (!diceselection[0]) {
			die0Value = (int) ((Math.random() * 5) + 1);
		}

		if (!diceselection[1]) {
			die1Value = (int) ((Math.random() * 5) + 1);
		}
		if (!diceselection[2]) {
			die2Value = (int) ((Math.random() * 5) + 1);
		}
		if (!diceselection[3]) {
			die3Value = (int) ((Math.random() * 5) + 1);
		}
		if (!diceselection[4]) {
			die4Value = (int) ((Math.random() * 5) + 1);
		}
		
		advanceTurn();

	}
	
	public void advanceTurn() {
		
		diceRollCount++;
		
		if (diceRollCount >= 3) {
			endTurn(currentPlayer);
			
		}
		
	}
	
	public void endTurn(String username) {
		if (diceRollCount == 0 || !username.equals(currentPlayer))
			return;
		
		diceRollCount = 0;
		strikeCount = 0;
		
		int index = findIndexOfPlayer(username);
		
		do {
			
		if (players.size() == index + 1)
			endRound();
		else if (index == -1 || 100 == 2) {
			System.out.println("failure. Player not found in game");
			return;
		} else {
			index += 1;
			currentPlayer = players.get(index).getYatzyUser().getUsername();
		}
		} while(players.get(index).getPlayerstate().equals(PlayerState.INACTIVE));
		
		
	}
	
	private void endRound() {
		if (roundCount < 15) {
			roundCount++;
			currentPlayer = players.get(0).getYatzyUser().getUsername();
		}
		
		else {
			gameState = GameState.FINISHED;
			currentPlayer = null;
			
		}
		
	}

	private int findIndexOfPlayer(String username) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getYatzyUser().getUsername().equals(username))
				return i;
		}
		
		return -1;
	}
	

//	public byte[] marshall() {
//		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		try {
//			ObjectOutputStream oos = new ObjectOutputStream(bos);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		
//		
//		List<byte[]> playersAsBytes = new ArrayList<byte[]>();
//		
//		players.stream().forEach(p -> playersAsBytes.add(p.marshall()));
//		
//	}
	
	public String getHostPlayer() {
		return hostPlayer;
	}

	public void setHostPlayer(String hostPlayer) {
		this.hostPlayer = hostPlayer;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getEventCounter() {
		return eventCounter;
	}

	public void setEventCounter(int eventCounter) {
		this.eventCounter = eventCounter;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public int getRoundCount() {
		return roundCount;
	}

	public void setRoundCount(int roundCount) {
		this.roundCount = roundCount;
	}

	public String getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(String currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public int getDiceRollCount() {
		return diceRollCount;
	}

	public void setDiceRollCount(int diceRollCount) {
		this.diceRollCount = diceRollCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public void setStrikeCount(int strikeCount) {
		this.strikeCount = strikeCount;
	}

	public int getDie0Value() {
		return die0Value;
	}

	public void setDie0Value(int die0Value) {
		this.die0Value = die0Value;
	}

	public int getDie1Value() {
		return die1Value;
	}

	public void setDie1Value(int die1Value) {
		this.die1Value = die1Value;
	}

	public int getDie2Value() {
		return die2Value;
	}

	public void setDie2Value(int die2Value) {
		this.die2Value = die2Value;
	}

	public int getDie3Value() {
		return die3Value;
	}

	public void setDie3Value(int die3Value) {
		this.die3Value = die3Value;
	}

	public int getDie4Value() {
		return die4Value;
	}

	public void setDie4Value(int die4Value) {
		this.die4Value = die4Value;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	

	public int getGameId() {
		return gameId;
	}

	public void poke(String username) {
		//TODO
		
	}
	
	public List<Integer> getDiceValues() {
		List<Integer> dice = new ArrayList<Integer>();
		
		dice.add(die0Value);
		dice.add(die1Value);
		dice.add(die2Value);
		dice.add(die3Value);
		dice.add(die4Value);
		
		
		
		return dice;
	}
	

}
