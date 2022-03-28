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
	
	@OneToOne
	private Player hostPlayer;
	
	@OneToMany(mappedBy="yatzyGame")
	private List<Player> players;
	
	

}
