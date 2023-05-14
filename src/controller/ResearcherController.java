package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Researcher;
import view.LoginPage;

public class ResearcherController {
	private Researcher model;
	private LoginPage view;
	
	public ResearcherController(Researcher model , LoginPage view) {
		this.model = model;
		this.view = view;
		model.addObserver(view);
		view.pressButton(new HandlePressButton());

	}
	

	class HandlePressButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("action performed controller");
			model.setName(view.getUsernameInput());
		}
	}
}
