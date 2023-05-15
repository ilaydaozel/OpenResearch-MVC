package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Researcher;
import view.*;


public class AuthController {
	private Researcher model;
	private LoginPage loginView;
	private MainPage mainView;
	
	public AuthController(Researcher model , LoginPage loginView) {
		System.out.println("model name ain authcontroller beginning: " + model.getName());
		this.model = model;
		this.loginView = loginView;
		model.addObserver(loginView);

		loginView.login(new LoginListener());
	}
	

	class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			model.setName(loginView.getUsernameInput());
			System.out.println("------------- login view passw input " + loginView.getPasswordInput());
			model.setPassword(loginView.getPasswordInput());
			model.isValidUser();

	        if(model.getLoggedIn())
	        {	System.out.println("login listener loggedIn: " +model.getLoggedIn());
	            loginView.dispose();
	            MainPage curMainView = new MainPage(model);
	            curMainView.setVisible(true);
	            mainView = curMainView;
	    		model.addObserver(mainView);
	    		mainView.logout(new LogoutListener());

	        }else {
	        	loginView.changeToErrorPage();
	        }
			
		}
	}
	
	class LogoutListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("logout");
			model.setLoggedIn(false);
			model.reset();
			System.out.println("name:" + model.getName());
			mainView.dispose();	
			System.out.println("*****************************new login");
			loginView.setVisible(true);
			/*LoginPage newLogin = new LoginPage(model);
			(newLogin).setVisible(true);
			loginView = newLogin;*/

		}
	}
}
