package view;

import java.awt.Dimension;
import java.util.List;
import java.util.Observable;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class ListContainer extends JPanel  {
	private List<Object> elementList;
	private JList list;
	
    public ListContainer(List<Object> elementList, int width, int heigth) {
    	this.elementList = elementList;
    	createList(width, heigth);
    }
    
    @SuppressWarnings("unchecked")
	private void createList(int width, int heigth) {
    	list = new JList(elementList.toArray());
    	//System.out.println("JList get model: "+ list.getModel());
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

	public List<Object> getElementList() {
		return elementList;
	}

	public void setElementList(List<Object> elementList) {
		this.elementList = elementList;
	}


}
