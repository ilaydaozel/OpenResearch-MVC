package main;

import controller.HomeController;
import controller.NavbarController;
import store.UserStore;
import view.HomePage;
import view.Navbar;

public class Manager {
	private Navbar navbar;
	private HomePage homeView;
	
	public void afterSuccessfulLogin(UserStore session) {
		if(session.getUser()!= null) {
			//creating homepage after login
			System.out.println("user in startup: " + session.getUser());
			this.navbar = new Navbar(session);
			NavbarController navbarController = new NavbarController(navbar, this);
			this.homeView = new HomePage(navbar);
			HomeController homeController = new HomeController(homeView);
		}
	}
	
	public void afterLogout(UserStore session) {
		if(session.getUser() == null) {
			System.out.println("after logout: " + session.getUser());
			homeView.dispose();			
		}
	}
	
	
}
