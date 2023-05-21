package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Manager;
import model.*;
import store.UserStore;
import view.*;


public class AuthController {
	private LoginPage loginView;
    private UserStore userStore;
	private Manager manager = new Manager();

	
	public AuthController(LoginPage loginView, UserStore session) {
    	this.userStore = session;
		this.loginView = loginView;
		loginView.login(new LoginListener());
	}
	

	class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			isValidUser(loginView.getUsernameInput(), loginView.getPasswordInput());
	        if(userStore.getUser() != null)
	        {
	            loginView.dispose();
	            manager.onLogin(userStore);
	            
	        }else {
	        	loginView.changeToErrorPage();
	        }
			
		}
	}
	
    public void isValidUser(String username, String password) {
    	ResearcherCollection researcherList = new ResearcherCollection();
    	for (Object researcher : researcherList.getCollection()) {
    		 if (((Researcher) researcher).getUsername().equals(username) && ((Researcher) researcher).getPassword().equals(password)) {
           	  	this.userStore.setUser((Researcher) researcher);
             }
    	}
    }

	public UserStore getUserStore() {
		return userStore;
	}
	public void setUserStore(UserStore userStore) {
		this.userStore = userStore;
	}
	
}
