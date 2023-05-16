package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;


public class ResearcherController {
	private ResearchersPage researchersView;
	
	public ResearcherController(ResearchersPage researchersView) {
		this.researchersView = researchersView;
		researchersView.selectResearcher(new SelectResearcherListener());;
	}

	class SelectResearcherListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("SelectResearcherListener / researcherController");
			Object selected = researchersView.getListContainer().getList().getSelectedValue();
			if(selected!= null) {
				researchersView.addDetailedContainer((Researcher) selected);
			}

		}
	}

}
