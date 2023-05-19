package view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import model.Researcher;


@SuppressWarnings("serial")
public class ResearcherListContainer extends JPanel{
	private List<Object> objectList;
	private JList list;
	
    public ResearcherListContainer(List<Object> researcherList, int width, int heigth) {
    	this.objectList = researcherList;
    	createList(width, heigth);
    }
    
    private void createList(int width, int heigth) {
    	list = new JList(objectList.toArray());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(list);  
        listScroller.setPreferredSize(new Dimension(width,heigth));
        add(listScroller);
    }

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public List<Object> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<Object> objectList) {
		this.objectList = objectList;
	}

}
