package main;

import model.*;
import view.*;
import controller.*;

public class OpenResearchApp {
	public static void main(String[] args) {
		Researcher model = new Researcher();
		LoginPage loginView = new LoginPage(model);
		//MainPage mainView = new MainPage(model);
		
		@SuppressWarnings("unused")
		AuthController controller = new AuthController(model,loginView);

		
		//mainView.setVisible(true);
		loginView.setVisible(true);
    	//BibTeXFileIO reader = new BibTeXFileIO();
    	//reader.readAllFilesInSameDirectory("src/data/");
    	

	}
}
