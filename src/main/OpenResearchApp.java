package main;

import model.*;
import view.*;
import controller.*;

public class OpenResearchApp {
	public static void main(String[] args) {
		//Researcher model = new Researcher();
		LoginPage loginView = new LoginPage();	
		//MainPage mainView = new MainPage(model);
		@SuppressWarnings("unused")
		AuthController controller = new AuthController(loginView);	
		//mainView.setVisible(true);
		loginView.setVisible(true);
		
		/*ResearchersList researcherView = new ResearchersList(new ResearcherCollection());
		researcherView.setVisible(true);*/

	}
}
