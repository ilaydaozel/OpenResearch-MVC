package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.*;
import view.*;


public class AccountController{
	private AccountPage accountView;
	private ReadingListCollection rLList;
	private Researcher researcher;
	
	public AccountController(AccountPage accountView, ReadingListCollection rLCollection, Researcher researcher) {
		this.accountView = accountView;
		this.rLList = rLCollection;	
		this.researcher = researcher;
		accountView.createNewReadingList(new CreateNewReadingListListener());
		
	}


	class CreateNewReadingListListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String rlName = accountView.getNewRLName().getText();
			System.out.println("Create new rl named " + rlName);
			System.out.println("r: "+ researcher.getUsername());
			ReadingList newReadingList = new ReadingList(rlName, researcher);
			researcher.addNewReadingList(newReadingList);
		
	
			System.out.println("rlist collection: "+ rLList.getCollection().toString());
		}
	}

}
