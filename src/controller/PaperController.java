package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.*;
import view.*;


public class PaperController {
	private PapersPage papersView;
	protected Paper selectedPaper;
	private PaperCollection paperList;
	
	public PaperController(PapersPage papersView, Collection paperList) {
		this.papersView = papersView;
		this.paperList = (PaperCollection) paperList;
		papersView.selectPaper(new SelectPaperListener());
		papersView.downloadFile(new DownloadPaperListener());
	}

	class SelectPaperListener implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			Object selected = papersView.getListContainer().getList().getSelectedValue();
			if(selected!= null) {
				papersView.addDetailedContainer((Paper) selected);
				selectedPaper = (Paper) selected;
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
	                paperList.updateCsvFile();
	                
	            } catch (IOException ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(papersView, "Error downloading file: " + ex.getMessage());
	            }
	        } else {
	            JOptionPane.showMessageDialog(papersView, "No paper selected.");
	        }
	    }
	}
	
	
}

