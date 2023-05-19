package controller;

import view.Navbar;

public class NavbarController {
	private Navbar navbar;
	
	public NavbarController(Navbar navbar) {
		this.navbar = navbar;
		//homeView.getNavbar().logout(new LogoutListener());
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
}
