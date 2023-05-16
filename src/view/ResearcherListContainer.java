package view;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import model.ResearcherCollection;

public class ResearcherListContainer extends JPanel {
	private ResearcherCollection researcherList = new ResearcherCollection();
    private JList list = new JList(researcherList.getResearchersList().toArray());
    
    public ResearcherListContainer() {
    	initComponents();
    }
    
    private void initComponents() {
    	//setPreferredSize(new Dimension(600,400));
    	setSize(960, 685);
    	setBackground(new Color(255,0,100));
		
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        //list.setPreferredSize(new Dimension(300,400));
        list.setVisibleRowCount(-1);
        //JScrollPane listScroller = new JScrollPane(list);  
        add(list);
    }

	public ResearcherCollection getResearcherList() {
		return researcherList;
	}
	public void setResearcherList(ResearcherCollection researcherList) {
		this.researcherList = researcherList;
	}
	public JList getList() {
		return list;
	}
	public void setList(JList list) {
		this.list = list;
	}
}
