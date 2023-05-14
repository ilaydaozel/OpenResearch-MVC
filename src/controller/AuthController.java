package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Researcher;
import view.LoginPage;

public class AuthController {
	private Researcher model;
	private LoginPage view;
	
	public AuthController(Researcher model , LoginPage view) {
		this.model = model;
		this.view = view;
		model.addObserver(view);
		view.login(new LoginListener());

	}
	

	class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			model.setName(view.getUsernameInput());
			model.setPassword(view.getPasswordInput());
			model.isValidUser();

	        if(model.getLoggedIn())
	        {
	            view.changeToMainPage();;       
	        }else {
	        	view.changeToErrorPage();
	        }
			
		}
	}
}
