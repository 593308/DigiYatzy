package gameClasses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import gameUtils.PLayerState;

@Entity
@IdClass(PlayerId.class)
public class Player {
	
	@Id
	private String username;
	private int gameId;
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
}
