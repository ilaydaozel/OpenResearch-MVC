package main;

import controller.HomeController;
import store.UserStore;
import view.HomePage;
import view.Navbar;

public class Manager {
	public void afterSuccessfulLogin(UserStore session) {
		if(session.getUser()!= null) {
			//creating homepage after login
			System.out.println("user in startup: " + session.getUser());
			Navbar navbar = new Navbar(session);
			HomePage homeView = new HomePage(navbar);
			HomeController homeController = new HomeController(homeView);
		}
	}
}
