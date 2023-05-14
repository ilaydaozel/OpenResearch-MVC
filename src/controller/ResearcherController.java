package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Researcher;
import view.LoginPage;

public class ResearcherController {
	private Researcher model;
	private LoginPage view;
	
	public ResearcherController(Researcher model , LoginPage view) {
		this.model = model;
		this.view = view;
		model.addObserver(view);
		view.pressButton(new PressButtonListener());
		view.login(new LoginListener());

	}
	

	class PressButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("action performed controller");
			model.setName(view.getUsernameInput());
		}
	}
	
	
	class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			model.setName(view.getUsernameInput());
			model.setPassword(view.getPasswordInput());

			/*
	        if(username.length() == 0 || password.length() == 0)
	        {
	            //JOptionPane.showMessageDialog(panelLogin, "Please enter Email and password", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }*/
			
	        /*if(dao.isValidAdmin(new Admin(id, password)))
	        {
	            loggedIn = true;
	            System.out.println("Logged in successfully");
	            new MainFrame().setVisible(true);
	            this.dispose();
	        }
	        else
	        {
	            JOptionPane.showMessageDialog(panelLogin, "Invalid Login!", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }*/
			System.out.println();
			if(model.isValidUser()) {
				 System.out.println("Valid");
			}
			else {
				System.out.println("False");
			}

			System.out.println("login controller");
			model.setName(view.getUsernameInput());
		}
	}
}
