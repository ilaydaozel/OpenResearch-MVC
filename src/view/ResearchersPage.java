
package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;

import interfaces.IPage;
import model.Researcher;
import model.ResearcherCollection;

public class ResearchersPage extends JPanel implements java.util.Observer{

    private ResearcherCollection model;
    private JLabel label = new JLabel("Researchers Page");
    private JButton viewButton = new JButton("view more");
    private JLabel selected = new JLabel("a");

	private ResearcherCollection researcherList = new ResearcherCollection();
    private JList list = new JList(researcherList.getResearchersList().toArray()); 
    //private JPanel contentPanel = new JPanel();

    public ResearchersPage() {
    	this.model = model;
    	initComponents();
    }

    private void initComponents() {
    	//setPreferredSize(new Dimension(600,400));
    	setBackground(new Color(255,255,255));
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        add(label, gridBagConstraints);
		
        this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        //list.setPreferredSize(new Dimension(300,400));
        list.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(list);
        //listScroller.setPreferredSize(new Dimension(250, 80));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(list, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(viewButton, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        add(selected, gridBagConstraints);
        
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("update/ mainpage");
		
	}
	
    public void selectResearcher(ActionListener actionListener) {
    	viewButton.addActionListener(actionListener);
    }

	public JButton getViewButton() {
		return viewButton;
	}

	public void setViewButton(JButton viewButton) {
		this.viewButton = viewButton;
	}

	public JLabel getSelected() {
		return selected;
	}

	public void setSelected(JLabel selected) {
		this.selected = selected;
	}
    public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

}
