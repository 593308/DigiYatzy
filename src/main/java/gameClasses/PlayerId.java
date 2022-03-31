package gameClasses;

import javax.persistence.Embeddable;


@Embeddable
public class PlayerId {
	
	private String yatzyUser;
	private int yatzyGame;
	
	public PlayerId(String yatzyUser, int yatzyGame) {
		this.yatzyUser = yatzyUser;
		this.yatzyGame = yatzyGame;
	}

	public String getYatzyUser() {
		return yatzyUser;
	}

	public void setYatzyUser(String yatzyUser) {
		this.yatzyUser = yatzyUser;
	}

	public int getYatzyGame() {
		return yatzyGame;
	}

	public void setYatzyGame(int yatzyGame) {
		this.yatzyGame = yatzyGame;
	}
	
	

}
