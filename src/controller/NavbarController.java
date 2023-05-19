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
		/*
		accountView= new AccountPage(researcherModel);
		ResearcherCollection researcherCollection = new ResearcherCollection();
		researchersView= new ResearchersPage(researcherModel);
		papersView= new PapersPage();
		mainView.getNavbar().showAccountPage(  new ShowAccountPageListener());
		mainView.getNavbar().showResearchersPage(  new ShowResearchersPageListener());
		mainView.getNavbar().showPapersPage(  new ShowPapersPageListener());
		 */
	}
	class LogoutListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {			
			System.out.println("logout");
			//mainView.dispose();	
			navbar.getUserStore().setUser(null);
			manager.afterLogout(navbar.getUserStore());
			//LoginPage newLogin = new LoginPage();
			//(newLogin).setVisible(true);
			//AuthController newController = new AuthController(newLogin);
		}
	}
}
