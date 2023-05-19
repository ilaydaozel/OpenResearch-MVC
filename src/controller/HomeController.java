package controller;

import controller.AuthController.LogoutListener;
import controller.AuthController.ShowAccountPageListener;
import controller.AuthController.ShowPapersPageListener;
import controller.AuthController.ShowResearchersPageListener;
import model.ResearcherCollection;
import view.AccountPage;
import view.HomePage;
import view.PapersPage;
import view.ResearchersPage;

public class HomeController {
	private HomePage homeView;
	
	public HomeController(HomePage homeView) {
		this.homeView = homeView;
		homeView.setVisible(true);
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
