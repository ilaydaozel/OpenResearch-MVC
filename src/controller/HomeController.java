package controller;

import view.HomePage;

public class HomeController {
	private HomePage homeView;
	
	public HomeController(HomePage homeView) {
		this.homeView = homeView;
		homeView.setVisible(true);

	}
	
}
