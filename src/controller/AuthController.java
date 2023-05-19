package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Manager;
import main.Startup;
import model.*;
import store.UserStore;
import view.*;


public class AuthController {
	private Researcher researcherModel;
	private LoginPage loginView;
    private UserStore userStore;
	private Manager manager = new Manager();

	private AccountPage accountView;
	private ResearchersPage researchersView;
	private PapersPage papersView;
	private ResearcherCollection researcherCollection = new ResearcherCollection() ;
	
	public AuthController(LoginPage loginView, UserStore session) {
    	this.userStore = session;
		this.loginView = loginView;
		loginView.login(new LoginListener());
	}
	

	class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//researcherModel = new Researcher(loginView.getUsernameInput(), loginView.getPasswordInput());
			//loginView.setModel(researcherModel);
			//researcherModel.addObserver(loginView);

			isValidUser(loginView.getUsernameInput(), loginView.getPasswordInput());

	        if(userStore.getUser() != null)
	        {	System.out.println("Logged in User: "+ userStore.getUser());
	            loginView.dispose();
	            manager.afterSuccessfulLogin(userStore);
	            
	        }else {
	        	loginView.changeToErrorPage();
	        }
			
		}
	}
	
    public void isValidUser(String username, String password) {
    	ResearcherCollection researcherList = new ResearcherCollection();
    	for (Researcher researcher : researcherList.getResearchersList()) {
    		 if (researcher.getUsername().equals(username) && researcher.getPassword().equals(password)) {
           	  	this.userStore.setUser(researcher);
             }
    	}
    }
    
	class ShowAccountPageListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("account");
			//mainView.changeContent(accountView);
		}
	}
	class ShowResearchersPageListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			/*
			System.out.println("reseacrhers");
			mainView.changeContent(researchersView);
			ResearcherController researcherController = new ResearcherController(researchersView);*/
		}
	}
	class ShowPapersPageListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//mainView.changeContent(papersView);
		}
	}
	class LogoutListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			/*
			System.out.println("logout");
			//researcherModel.setLoggedIn(false);
			researcherModel.reset();
			System.out.println("name:" + researcherModel.getUsername());
			mainView.dispose();	
			System.out.println("*****************************new login");
			//loginView.setVisible(true);
			
			LoginPage newLogin = new LoginPage();
			(newLogin).setVisible(true);
			AuthController newController = new AuthController(newLogin);
*/
		}
	}

	public UserStore getUserStore() {
		return userStore;
	}
	public void setUserStore(UserStore userStore) {
		this.userStore = userStore;
	}
	
}
