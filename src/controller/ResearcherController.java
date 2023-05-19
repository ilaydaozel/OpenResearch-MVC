package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;


public class ResearcherController {
	private ResearchersPage researchersView;
	
	public ResearcherController(ResearchersPage researchersView) {
		this.researchersView = researchersView;
		researchersView.selectResearcher(new SelectResearcherListener());
		researchersView.getDetailedContainer().followResearcher(new FollowListener());
		researchersView.getDetailedContainer().unfollowResearcher(new UnfollowListener());
	}

	class SelectResearcherListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("SelectResearcherListener / researcherController");
			Object selected = researchersView.getResearcherListWrapper().getListContainer().getList().getSelectedValue();
			if(selected!= null) {
				researchersView.addDetailedContainer((Researcher) selected);
			}

		}
	}
	class FollowListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//userı alma yerini düşün
			Object selected = researchersView.getResearcherListWrapper().getListContainer().getList().getSelectedValue();
			if(selected!= null) {
				System.out.println(selected + "followed / controller");
				researchersView.getModel().follow((Researcher) selected);
			}

		}
	}
	class UnfollowListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//userı alma yerini düşün
			Object selected = researchersView.getResearcherListWrapper().getListContainer().getList().getSelectedValue();
			if(selected!= null) {
				System.out.println(selected + "unfollowed / controller");
				researchersView.getModel().unfollow((Researcher) selected);
			}


		}
	}


}
