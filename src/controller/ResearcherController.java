package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;


public class ResearcherController {
	private Researcher model;
	private LoginPage loginView;
	private MainPage mainView;
	private AccountPage accountView;
	private ResearchersPage researchersView;
	private PapersPage papersView;
	private ResearcherCollection researcherCollection = new ResearcherCollection() ;
	
	public ResearcherController(ResearchersPage researchersView) {
		this.researchersView = researchersView;
		researchersView.selectResearcher(new SelectResearcherListener());;
	}
	

	class SelectResearcherListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("SelectResearcherListener / researcherController");
			//objeyi değiştir
			Object selected = researchersView.getListContainer().getList().getSelectedValue();
			if(selected!= null) {
				researchersView.getSelected().setText(selected.toString());
			}

		}
	}

}
