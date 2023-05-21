package main;

import java.util.Iterator;

import controller.*;
import model.Collection;
import model.PaperCollection;
import model.ReadingListCollection;
import model.Researcher;
import model.ResearcherCollection;
import store.UserStore;
import view.*;


public class Manager {
	private Navbar navbar;
	private HomePage homeView;
	private AccountPage accountView;
	private ResearchersPage researcherView;
	private PapersPage paperView;
	private Collection paperCollection;
	private Collection researcherCollection;
	private Collection readingListCollection;
	
	public void initialize() {
		//initializing login
		UserStore session = new UserStore(); 
		LoginPage loginView = new LoginPage();
		AuthController authController = new AuthController(loginView, session);	
		loginView.setVisible(true);		
	}
	
	public void onLogin(UserStore session) {
		if(session.getUser()!= null) {
			Researcher researcher = session.getUser();

			//creating homepage after login
			this.navbar = new Navbar(session);
			NavbarController navbarController = new NavbarController(navbar, this);
			
			this.homeView = new HomePage(navbar);
			HomeController homeController = new HomeController(homeView);
			
			
			this.researcherCollection = new ResearcherCollection();
			
			ResearcherCollection resCol =  (ResearcherCollection) researcherCollection;
			Researcher researcherFromCollection = resCol.getResearcherByResearcherName(researcher.getUsername());
			
			this.researcherView = new ResearchersPage(researcherCollection);
			ResearcherController researcherController 
						= new ResearcherController(researcherView,(ResearcherCollection) researcherCollection, researcherFromCollection);
			
			
			this.readingListCollection = new ReadingListCollection((ResearcherCollection)this.researcherCollection);
			
			this.accountView = new AccountPage(researcherFromCollection);
			AccountController accountController = new AccountController(accountView, (ReadingListCollection) readingListCollection, researcherFromCollection);

			
			this.paperCollection = new PaperCollection();
			this.paperView = new PapersPage(paperCollection, researcherFromCollection );
			PaperController paperController = new PaperController(paperView, (PaperCollection) paperCollection);
			
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
