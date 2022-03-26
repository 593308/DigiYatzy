package classes;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="yatzy")
public class YatzyUser {
	
	@Id
	private String username; 
	private String email; 
	@Embedded
	private Password password;
	
	public YatzyUser() {
		
	}
	
	public YatzyUser(String username, String email, Password password) {
		super(); 
		this.username = username; 
		this.email = email; 
		this.password = password; 
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}
	
}
