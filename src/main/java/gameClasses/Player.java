package gameClasses;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import classes.YatzyUser;
import gameUtils.PlayerState;

@Entity
@Table(schema = "yatzy")
@IdClass(PlayerId.class)
public class Player {

	@Id
	@ManyToOne
	@JoinColumn(name="username")
	private YatzyUser yatzyUser;
	
	@Id
	@ManyToOne
	@JoinColumn(name="gameId")
	private YatzyGame yatzyGame;
	
	

	private PlayerState playerstate;
	private int onesScore;
	private int twosScore;
	private int threesScore;
	private int foursScore;
	private int fivesScore;
	private int sixesScore;
	private int bonusScore;
	private int onePairScore;
	private int twoPairsScore;
	private int threeOfAKindScore;
	private int fourOfAKindScore;
	private int smallStraightScore;
	private int largeStraightScore;
	private int fullHouseScore;
	private int chanceScore;
	private int yatzyScore;
	private int totalScore;

	public Player(YatzyUser yatzyUser, YatzyGame yatzyGame) {
		
		this.yatzyUser = yatzyUser;
		this.yatzyGame = yatzyGame;
		
		yatzyGame.addPlayer(this);
		yatzyUser.makePlayer(this);
		
		playerstate = PlayerState.ACTIVE;

		onesScore = 0;
		twosScore = 0;
		threesScore = 0;
		foursScore = 0;
		fivesScore = 0;
		sixesScore = 0;
		bonusScore = 0;
		onePairScore = 0;
		twoPairsScore = 0;
		threeOfAKindScore = 0;
		fourOfAKindScore = 0;
		smallStraightScore = 0;
		largeStraightScore = 0;
		fullHouseScore = 0;
		chanceScore = 0;
		yatzyScore = 0;
		totalScore = 0;

	}
	
	public Player() {
		
	}
	

	public YatzyUser getYatzyUser() {
		return yatzyUser;
	}

	public void setYatzyUser(YatzyUser yatzyUser) {
		this.yatzyUser = yatzyUser;
	}

	public YatzyGame getYatzyGame() {
		return yatzyGame;
	}

	public void setYatzyGame(YatzyGame yatzyGame) {
		this.yatzyGame = yatzyGame;
	}

	public PlayerState getPlayerstate() {
		return playerstate;
	}

	public void setPlayerstate(PlayerState playerstate) {
		this.playerstate = playerstate;
	}

	public int getOnesScore() {
		return onesScore;
	}

	public void setOnesScore(int onesScore) {
		this.onesScore = onesScore;
	}

	public int getTwosScore() {
		return twosScore;
	}

	public void setTwosScore(int twosScore) {
		this.twosScore = twosScore;
	}

	public int getThreesScore() {
		return threesScore;
	}

	public void setThreesScore(int threesScore) {
		this.threesScore = threesScore;
	}

	public int getFoursScore() {
		return foursScore;
	}

	public void setFoursScore(int foursScore) {
		this.foursScore = foursScore;
	}

	public int getFivesScore() {
		return fivesScore;
	}

	public void setFivesScore(int fivesScore) {
		this.fivesScore = fivesScore;
	}

	public int getSixesScore() {
		return sixesScore;
	}

	public void setSixesScore(int sixesScore) {
		this.sixesScore = sixesScore;
	}

	public int getBonusScore() {
		return bonusScore;
	}

	public void setBonusScore(int bonusScore) {
		this.bonusScore = bonusScore;
	}

	public int getOnePairScore() {
		return onePairScore;
	}

	public void setOnePairScore(int onePairScore) {
		this.onePairScore = onePairScore;
	}

	public int getTwoPairsScore() {
		return twoPairsScore;
	}

	public void setTwoPairsScore(int twoPairsScore) {
		this.twoPairsScore = twoPairsScore;
	}

	public int getThreeOfAKindScore() {
		return threeOfAKindScore;
	}

	public void setThreeOfAKindScore(int threeOfAKindScore) {
		this.threeOfAKindScore = threeOfAKindScore;
	}

	public int getFourOfAKindScore() {
		return fourOfAKindScore;
	}

	public void setFourOfAKindScore(int fourOfAKindScore) {
		this.fourOfAKindScore = fourOfAKindScore;
	}

	public int getSmallStraightScore() {
		return smallStraightScore;
	}

	public void setSmallStraightScore(int smallStraightScore) {
		this.smallStraightScore = smallStraightScore;
	}

	public int getLargeStraightScore() {
		return largeStraightScore;
	}

	public void setLargeStraightScore(int largeStraightScore) {
		this.largeStraightScore = largeStraightScore;
	}

	public int getFullHouseScore() {
		return fullHouseScore;
	}

	public void setFullHouseScore(int fullHouseScore) {
		this.fullHouseScore = fullHouseScore;
	}

	public int getChanceScore() {
		return chanceScore;
	}

	public void setChanceScore(int chanceScore) {
		this.chanceScore = chanceScore;
	}

	public int getYatzyScore() {
		return yatzyScore;
	}

	public void setYatzyScore(int yatzyScore) {
		this.yatzyScore = yatzyScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

//	public byte[] marshall() {
//		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		try {
//			ObjectOutputStream oos = new ObjectOutputStream(bos);
//			oos.writeObject(this);
//			oos.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		return bos.toByteArray();
//		
//		
//	}
	
	

}