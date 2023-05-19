package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import model.ResearcherCollection;

public class ListWrapper extends JPanel {
	
    private JLabel label;
    private Color blue = new Color(144, 219, 244);
	private ListContainer listContainer; 
    private JButton viewButton = new JButton("View more");
    
	public ListWrapper(String title, List<Object> elementList, int width, int heigth) {
		label = new JLabel(title);
		listContainer = new ListContainer(elementList, width, heigth);
		
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
	
    public void selectResearcher(ActionListener actionListener) {
    	viewButton.addActionListener(actionListener);
    }
    public ListContainer getListContainer() {
		return listContainer;
	}

	public void setListContainer(ListContainer listContainer) {
		this.listContainer = listContainer;
	}



}