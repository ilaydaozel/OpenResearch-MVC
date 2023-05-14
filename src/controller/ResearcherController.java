package controller;

import java.awt.event.ActionEvent;

import model.Researcher;
import view.LoginPage;

public class ResearcherController {
	private Researcher model;
	private LoginPage view;
	
	public ResearcherController(Researcher model , LoginPage view) {
		this.model = model;
		this.view = view;
		model.addObserver(view);
	    this.view.pressButton(e -> {
	    	actionPerformed(e);
	    });
	}
	
	public void actionPerformed(ActionEvent evt) {
		this.model.setName(this.view.getUsernameInput());
	}
}
