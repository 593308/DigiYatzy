package gameClasses;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "yatzy")
public class YatzyGame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gameId;
	
	private String hostplayer;
	
	@OneToMany(mappedBy="yatzyGame")
	private List<Player> players;
	
	
	private int eventCounter;
	private String gameSate;
	private int roundCount;
	private String currentPlayer;
	private int diceRollCount;
	private int strikCount;
	private int die0Value;
	private int die1Value;
	private int die2Value;
	private int die3Value;
	private int die4Value;
	
	private Die[] dice;
	
	
	
	
	
	
	
	
	public YatzyGame(String hostplayer) {
		this.hostplayer = hostplayer;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void removePlayer(Player player) {
		players.remove(player);
	}
	
	
	
	

}
