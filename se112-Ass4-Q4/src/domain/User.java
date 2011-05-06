package domain;

import java.util.Observable;
import java.util.Observer;

public class User implements Observer {

	private String username;
	
	public User(String username) {
		setUsername(username);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 instanceof String)
			System.out.println(getUsername() + " got an update: " + arg1);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
}
