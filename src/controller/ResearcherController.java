package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.*;
import view.*;


public class ResearcherController{
	private ResearchersPage researchersView;
	private ResearcherCollection researcherList;
	private Researcher researcher;
	protected Researcher selectedResearcher;
	
	public ResearcherController(ResearchersPage researchersView, ResearcherCollection researcherCollection, Researcher researcher) {
		this.researchersView = researchersView;
		this.researcherList = researcherCollection;	
		this.researcher = researcher;
		researchersView.selectResearcher(new SelectResearcherListener());
		researchersView.followResearcher(new FollowListener());
		researchersView.unfollowResearcher(new UnfollowListener());
	}

	class SelectResearcherListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			Object selected = researchersView.getListContainer().getList().getSelectedValue();
			if(selected!= null) {
				researchersView.addDetailedContainer((Researcher) selected);
				selectedResearcher = (Researcher) selected;
			}
			
		}
	}
	class FollowListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			if(researcher.getFollowingResearchers().contains( selectedResearcher.getUsername())) {
				JOptionPane.showMessageDialog(researchersView, "You are already following selected researcher.");
				return;
			}
			if(selectedResearcher!= null) {
				researcher.follow((Researcher) selectedResearcher);
			}

			else {
	            JOptionPane.showMessageDialog(researchersView, "No researcher selected.");
	        }

		}
	}
	class UnfollowListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(!researcher.getFollowingResearchers().contains( selectedResearcher.getUsername())) {
				JOptionPane.showMessageDialog(researchersView, "You are not following selected researcher.");
				return;
			}
			if(selectedResearcher!= null ) {
				researcher.unfollow((Researcher) selectedResearcher);
			}
			else {
	            JOptionPane.showMessageDialog(researchersView, "No researcher selected.");
	        }

		}
	}


}
