package classes;

import javax.persistence.Embeddable;

import utils.PasswordUtil;

@Embeddable
public class Password {

	private String pwd_hash;
    private String pwd_salt;
    
    /**
     * 
     * @param hash
     * @param salt
     * 
     * Creates a Password containing a hash and a salt
     */
    
    
	private Password(String hash, String salt) {
		pwd_hash = hash;
		pwd_salt = salt;
	}
	
	public Password() {}

	@Override
	public String toString() {
		return "Password [pwd_hash=" + pwd_hash + ", pwd_salt=" + pwd_salt + "]";
	}

	/**
	 * 
	 * @param realPassword
	 * @return an object of the type Password
	 * 
	 * Makes a password from a random generated salt and a generated hash
	 */
	public static Password createPassword(String realPassword) {
		String salt = PasswordUtil.generateRandomSalt();
		String hash = PasswordUtil.hashWithSalt(realPassword, salt);
		return new Password(hash, salt);
	}
	
	public String getSalt() {
		return pwd_salt;
	}
	
	public String getHash() {
		return pwd_hash;
	}
}