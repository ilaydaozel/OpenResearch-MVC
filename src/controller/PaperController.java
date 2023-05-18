package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;


public class PaperController {
	private PapersPage papersView;
	
	public PaperController(PapersPage papersView) {
		this.papersView = papersView;
		papersView.selectPaper(new SelectPaperListener());;
	}

	class SelectPaperListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("SelectResearcherListener / researcherController");
			//Object selected = papersView.getListContainer().getList().getSelectedValue();
			/*if(selected!= null) {
				papersView.addDetailedContainer((Paper) selected);
			}*/

		}
	}

}
