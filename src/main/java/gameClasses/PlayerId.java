package gameClasses;

import javax.persistence.Embeddable;

import classes.YatzyUser;

@Embeddable
public class PlayerId {
	
	private YatzyUser username;
	private YatzyGame gameId;
	
	public PlayerId(YatzyUser username, YatzyGame gameId) {
		this.username = username;
		this.gameId = gameId;
	}

}
