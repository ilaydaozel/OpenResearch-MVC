package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import model.*;
import view.*;


public class PaperController {
	private PapersPage papersView;
	
	public PaperController(PapersPage papersView) {
		this.papersView = papersView;
		papersView.selectPaper(new SelectPaperListener());
		papersView.downloadFile(new DownloadPaperListener());
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
	class DownloadPaperListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        try {
	            Path source = Paths.get("OpenResearch-MVC/src/data/A_2005_Introducing Test Automation and Test-Driven Development.pdf");
	            Path destination = Paths.get("downloaded_file.pdf");
	
	            Files.copy(source, destination);
	            JOptionPane.showMessageDialog(papersView, "File downloaded successfully!");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(papersView, "Error downloading file: " + ex.getMessage());
	        }
	    }
}
}
