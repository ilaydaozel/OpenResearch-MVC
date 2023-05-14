package main;

import model.Researcher;
import view.LoginPage;
import controller.AuthController;

public class OpenResearchApp {
	public static void main(String[] args) {
		Researcher model = new Researcher();
		LoginPage view = new LoginPage(model);
		@SuppressWarnings("unused")
		AuthController controller = new AuthController(model,view);
		
		view.setVisible(true);
	}
}
