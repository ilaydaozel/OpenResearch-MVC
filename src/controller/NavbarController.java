package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Manager;
import view.Navbar;

public class NavbarController {
	private Navbar navbar;
	private Manager manager;
	
	public NavbarController(Navbar navbar, Manager manager) {
		this.navbar = navbar;
		this.manager = manager;
		navbar.logout(new LogoutListener());
		navbar.navigate(new ChangePageListener());
	}
	class LogoutListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {	
			navbar.getUserStore().setUser(null);
			manager.onLogout(navbar.getUserStore());
		}
	}
	
	class ChangePageListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String destination = e.getActionCommand();
			manager.changeHomeContent(destination);
		}
	}
}
