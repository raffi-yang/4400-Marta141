package Model;

import java.util.List;

/**
 * Created by JARVIS on 4/13/17.
 * @param <E>
 */
public class User {

    private String userName;
    private String password;
    private String email;
    private boolean isAdmin;

    public User(String userName, String password, boolean isAdmin) {
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
	}
    
    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    
    public String getEmail() {
    	return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    public void setEmail(String email){
    	this.email = email;
    }

}
