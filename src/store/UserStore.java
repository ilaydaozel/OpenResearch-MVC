package store;

import model.Researcher;

public class UserStore {
	private static Researcher user;
	
	public UserStore() {
		
	}

	public static Researcher getUser() {
		return user;
	}

	public void setUser(Researcher user) {
		this.user = user;
	}
	

}
