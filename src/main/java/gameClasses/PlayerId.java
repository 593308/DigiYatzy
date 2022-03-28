package gameClasses;

import javax.persistence.Embeddable;

import classes.YatzyUser;

@Embeddable
public class PlayerId {
	
	private String username;
	private int gameId;
	
	public PlayerId(String username, int gameId) {
		this.username = username;
		this.gameId = gameId;
	}

}
