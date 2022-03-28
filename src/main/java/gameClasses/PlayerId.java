package gameClasses;

import javax.persistence.Embeddable;

import classes.YatzyUser;

@Embeddable
public class PlayerId {
	
	private String yatzyUser;
	private int yatzyGame;
	
	public PlayerId(String yatzyUser, int yatzyGame) {
		this.yatzyUser = yatzyUser;
		this.yatzyGame = yatzyGame;
	}

}
