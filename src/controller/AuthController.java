package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.PageController.ShowAccountPageListener;
import controller.PageController.ShowResearchersPageListener;
import model.Researcher;
import view.*;


public class AuthController {
	private Researcher model;
	private LoginPage loginView;
	private MainPage mainView;
	private Navbar navbar;
	private AccountPage accountView;
	private ResearchersPage researchersView;
	private PapersPage papersView;
	
	public AuthController(LoginPage loginView) {
		//System.out.println("model name ain authcontroller beginning: " + model.getUsername());
		//this.model = model;
		this.loginView = loginView;
		loginView.login(new LoginListener());
	}
	

	class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			model = new Researcher(loginView.getUsernameInput(), loginView.getPasswordInput());
			loginView.setModel(model);
			model.addObserver(loginView);
			//model.setUsername();
			System.out.println("------------- login view passw input " + loginView.getPasswordInput());
			//model.setPassword(loginView.getPasswordInput());
			model.isValidUser();

	        if(model.getLoggedIn())
	        {	System.out.println("login listener loggedIn: " +model.getLoggedIn());
	            loginView.dispose();
	            MainPage curMainView = new MainPage(model);
	            curMainView.setVisible(true);
	            mainView = curMainView;
	    		model.addObserver(mainView);
	    		//PageController pageController = new PageController(model, mainView);
	    		mainView.getNavbar().logout(new LogoutListener());
	    		accountView= new AccountPage(model);
	    		researchersView= new ResearchersPage(model);
	    		papersView= new PapersPage(model);
	    		mainView.getNavbar().showAccountPage(  new ShowAccountPageListener());
	    		mainView.getNavbar().showResearchersPage(  new ShowResearchersPageListener());
	    		mainView.getNavbar().showPapersPage(  new ShowPapersPageListener());

	        }else {
	        	loginView.changeToErrorPage();
	        }
			
		}
	}
	class ShowAccountPageListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("account");
			mainView.setContent(accountView);
		}
	}
	class ShowResearchersPageListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("rseacrhers");
			mainView.setContent(researchersView);
		}
	}
	class ShowPapersPageListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			mainView.setContent(papersView);
		}
	}
	class LogoutListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("logout");
			model.setLoggedIn(false);
			model.reset();
			System.out.println("name:" + model.getUsername());
			mainView.dispose();	
			System.out.println("*****************************new login");
			//loginView.setVisible(true);
			
			LoginPage newLogin = new LoginPage();
			(newLogin).setVisible(true);
			loginView = newLogin;

		}
	}
}
