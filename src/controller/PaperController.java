package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.*;
import view.*;


public class PaperController {
	private PapersPage papersView;
	protected Paper selectedPaper;
	protected String selectedReadingListName;
	private PaperCollection paperList;
	private Researcher researcher;
	
	public PaperController(PapersPage papersView, Collection paperList, Researcher researcher) {
		this.papersView = papersView;
		this.paperList = (PaperCollection) paperList;
		this.researcher = researcher;
		papersView.selectPaper(new SelectPaperListener());
		papersView.downloadFile(new DownloadPaperListener());
		papersView.selectReadingList(new SelectReadingListListener());
		papersView.addToReadingList(new AddPaperToReadingListListener());
		papersView.removeFromReadingList(new RemovePaperfromReadingListListener());
	}

	class SelectPaperListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			if( papersView.getListContainer().getList().getSelectedValue() !=null) {
				Object selected = papersView.getListContainer().getList().getSelectedValue();
				
					papersView.addDetailedContainer((Paper) selected);
					selectedPaper = (Paper) selected;
				
			}
			
		}
	}
	
	class SelectReadingListListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			Object objSelectedReadingListName = papersView.getRlList().getSelectedValue();		
			if(objSelectedReadingListName!= null) {
				selectedReadingListName = ((ReadingList )objSelectedReadingListName).getReadingListName();
			}

		}
	}
	
	class DownloadPaperListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {

	    	if (selectedPaper != null) {
	            try {
	                String fileName = selectedPaper.toString().replace(":", "") + ".pdf";
	                Path source = Paths.get("src/data/" + fileName);
	                Path destination = Paths.get("copy_" + fileName);
	                if(Files.exists(destination)) {
	                	int response = JOptionPane.showConfirmDialog(papersView, "This file already exists. Do you want to download again?", "File Exists", JOptionPane.YES_NO_OPTION);
	                    if (response == JOptionPane.YES_OPTION) {
	                    	Files.delete(destination);
	                    }
	                    else {
	                    	return;
	                    }
	                	
	                }
	                Files.copy(source, destination);
	                JOptionPane.showMessageDialog(papersView, "File downloaded successfully!");
	                selectedPaper.setDownloadNumber(selectedPaper.getDownloadNumber() + 1);
	             
	                // Update paperList if selectedPaper is in the list
	                paperList.updateFile();
	                
	            } catch (IOException ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(papersView, "Error downloading file: " + ex.getMessage());
	            }
	        } else {
	            JOptionPane.showMessageDialog(papersView, "No paper selected.");
	        }
	    }
	}
	
	class AddPaperToReadingListListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	if(selectedReadingListName != null) {
	    		if (selectedPaper != null) {
		    		if(researcher.getReadingLists()!= null) {
		    			if(researcher.addToReadingList(selectedReadingListName, selectedPaper.getTitle())) {
		    				JOptionPane.showMessageDialog(papersView, "Paper added successfully!");
		    				return;
		    			}
		    			else {
		    				JOptionPane.showMessageDialog(papersView, "Paper already exist in the "+ selectedReadingListName );
		    			}
		    		}
		    		else {
		    			JOptionPane.showMessageDialog(papersView, "Researcher has no reading list.");
		    		}
		    	}
		    	else {
		    		JOptionPane.showMessageDialog(papersView, "No paper selected.");
		    	}
		    }
	    	else {
	    		JOptionPane.showMessageDialog(papersView, "No reading list selected. Login again and select a reading list first.");
	    	}
	    }
	    	
	}
	class RemovePaperfromReadingListListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	if(selectedReadingListName != null) {
	    		if (selectedPaper != null) {
		    		if(researcher.getReadingLists()!= null) {
		    			if(researcher.removeFromReadingList(selectedReadingListName, selectedPaper.getTitle())) {
		    				JOptionPane.showMessageDialog(papersView, "Paper removed successfully!");
		    				return;
		    			}
		    			else {
		    				JOptionPane.showMessageDialog(papersView, "Paper do not exist in the "+ selectedReadingListName );
		    			}
		    		}
		    		else {
		    			JOptionPane.showMessageDialog(papersView, "Researcher has no reading list.");
		    		}
		    	}
		    	else {
		    		JOptionPane.showMessageDialog(papersView, "No paper selected.");
		    	}
		    }
		    else {
		    	JOptionPane.showMessageDialog(papersView, "No reading list selected. Login again  and select a reading list first.");
		    }
	    }

	    	
	}
	
	
}

