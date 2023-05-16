package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.ListSelectionModel;

import model.ResearcherCollection;

@SuppressWarnings("serial")
public class ResearcherListContainer extends JPanel {
	private ResearcherCollection researcherList = new ResearcherCollection();
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private JList list = new JList(researcherList.getResearchersList().toArray());
    
    public ResearcherListContainer() {
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

	public ResearcherCollection getResearcherList() {
		return researcherList;
	}
	public void setResearcherList(ResearcherCollection researcherList) {
		this.researcherList = researcherList;
	}
	@SuppressWarnings("rawtypes")
	public JList getList() {
		return list;
	}
	public void setList(@SuppressWarnings("rawtypes") JList list) {
		this.list = list;
	}
}
