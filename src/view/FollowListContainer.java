package view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class FollowListContainer extends JPanel {
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private JList list;
    
    @SuppressWarnings("unchecked")
	public FollowListContainer(List<Object> followList) {
    	this.list = new JList(followList.toArray());
    	initComponents();
    }
    
    private void initComponents() {
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(list);  
        listScroller.setPreferredSize(new Dimension(100,30));
        add(listScroller);
    }
    
	@SuppressWarnings("rawtypes")
	public JList getList() {
		return list;
	}
	public void setList(@SuppressWarnings("rawtypes") JList list) {
		this.list = list;
	}

}
