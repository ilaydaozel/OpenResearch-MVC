package main;

import controller.*;
import view.*;
import store.UserStore;

public class Startup {
	public void initialize() {
		//initializing login
		UserStore session = new UserStore(); 
		LoginPage loginView = new LoginPage();
		AuthController authController = new AuthController(loginView, session);	
		loginView.setVisible(true);		
	}
	
}
