package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.ListSelectionModel;

import interfaces.IFileReader;
import interfaces.IFileWriter;
import model.BibTeXFileIO;
import model.CsvFileIO;
import model.PaperCollection;

@SuppressWarnings("serial")
public class PaperListContainer extends JPanel {
	
	private PaperCollection paperList = new PaperCollection();
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private JList list = new JList(paperList.getPapers().toArray());
    
    public PaperListContainer() {
    	initComponents();
    }
    
    private void initComponents() {
    	
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(list);  
        listScroller.setPreferredSize(new Dimension(500,100));
        add(listScroller);
    }

	public PaperCollection getResearcherList() {
		return paperList;
	}
	public void setResearcherList(PaperCollection researcherList) {
		this.paperList = researcherList;
	}
	@SuppressWarnings("rawtypes")
	public JList getList() {
		return list;
	}
	public void setList(@SuppressWarnings("rawtypes") JList list) {
		this.list = list;
	}
}
