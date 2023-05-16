
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
    private ResearcherListContainer listContainer = new ResearcherListContainer();

	 
    //private JPanel contentPanel = new JPanel();

    public ResearchersPage() {
    	this.model = model;
    	initComponents();
    }

    private void initComponents() {
    	//setPreferredSize(new Dimension(600,400));
    	setSize(960, 685);
    	setBackground(new Color(255,255,255));
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        add(label, gridBagConstraints);
	
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(listContainer, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(viewButton, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        add(selected, gridBagConstraints);
        
    }

	public ResearcherListContainer getListContainer() {
		return listContainer;
	}

	public void setListContainer(ResearcherListContainer listContainer) {
		this.listContainer = listContainer;
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


}
