package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class ResearcherListWrapper extends JPanel {
    private JLabel label = new JLabel("Researchers Page");
    private Color blue = new Color(144, 219, 244);
    private ResearcherListContainer listContainer = new ResearcherListContainer();
    private JButton viewButton = new JButton("View more");
    
	public ResearcherListWrapper() {
		initComponents();
	}
	
	private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints listGridBagConstraints = new GridBagConstraints();

        listGridBagConstraints.gridx = 0;
        listGridBagConstraints.gridy = 0;
        label.setFont(new Font("", Font.BOLD, 20));
        add(label, listGridBagConstraints);
	
        listGridBagConstraints.gridx = 0;
        listGridBagConstraints.gridy = 1;

        add(listContainer, listGridBagConstraints);
        
        listGridBagConstraints.gridx = 0;
        listGridBagConstraints.gridy = 2;
        viewButton.setBackground(blue);
        viewButton.setPreferredSize(new Dimension(150,30));
        listGridBagConstraints.anchor = listGridBagConstraints.EAST;
        add(viewButton, listGridBagConstraints);
	}
	public JButton getViewButton() {
		return viewButton;
	}

	public void setViewButton(JButton viewButton) {
		this.viewButton = viewButton;
	}

	public ResearcherListContainer getListContainer() {
		return listContainer;
	}

	public void setListContainer(ResearcherListContainer listContainer) {
		this.listContainer = listContainer;
	}


}
