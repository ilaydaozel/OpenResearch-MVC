package main;

import controller.*;
import store.UserStore;
import view.*;


public class Manager {
	private Navbar navbar;
	private HomePage homeView;
	private AccountPage accountView;
	private ResearchersPage researcherView;
	private PapersPage paperView;
	
	public void initialize() {
		//initializing login
		UserStore session = new UserStore(); 
		LoginPage loginView = new LoginPage();
		AuthController authController = new AuthController(loginView, session);	
		loginView.setVisible(true);		
	}
	
	public void onLogin(UserStore session) {
		if(session.getUser()!= null) {
			//creating homepage after login
			System.out.println("user in startup: " + session.getUser());
			this.navbar = new Navbar(session);
			NavbarController navbarController = new NavbarController(navbar, this);
			this.homeView = new HomePage(navbar);
			HomeController homeController = new HomeController(homeView);
			this.accountView = new AccountPage(session.getUser());
			//Account accountController = new AccountPage();
			this.researcherView = new ResearchersPage(session.getUser());
			ResearcherController researcherController = new ResearcherController(researcherView);
			this.paperView = new PapersPage();
			PaperController paperController = new PaperController(paperView);
			
		}
	}
	
	public void onLogout(UserStore session) {
		if(session.getUser() == null) {
			System.out.println("after logout: " + session.getUser());
			homeView.dispose();			
		}
	}
	
	public void changeHomeContent(String destination) {
		switch(destination) {
			case "Researchers":
				homeView.changeContent(researcherView);
				break;
			case "My Account":
				homeView.changeContent(accountView);
				break;
			case "Papers":
				homeView.changeContent(paperView);
				break;
		    default:
		    	System.out.println("No page found");
		    	break;
		}
	}	
}
