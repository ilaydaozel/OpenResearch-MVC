package main;

import model.Researcher;
import view.LoginPage;
import controller.ResearcherController;

public class OpenResearchApp {
	public static void main(String[] args) {
		Researcher model = new Researcher();
		LoginPage view = new LoginPage(model);
		@SuppressWarnings("unused")
		ResearcherController controller = new ResearcherController(model,view);
		
		view.setVisible(true);
	}
}
