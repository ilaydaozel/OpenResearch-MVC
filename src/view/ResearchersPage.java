
package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;

import interfaces.IPage;
import model.Researcher;
import model.ResearcherCollection;

public class ResearchersPage extends JPanel implements java.util.Observer{
    private JLabel label = new JLabel("Researchers Page");
    private JButton viewButton = new JButton("View more");
    private ResearcherListContainer listContainer = new ResearcherListContainer();
    private ResearcherDetailedContainer detailedContainer;
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private Color blue = new Color(144, 219, 244);
    
    public ResearchersPage() {
    	initComponents();
    }

    private void initComponents() {

        setLayout(new GridBagLayout());
        
        JPanel researchersList = new JPanel();
        researchersList.setLayout(new GridBagLayout());
        GridBagConstraints listGridBagConstraints = new GridBagConstraints();

        listGridBagConstraints.gridx = 0;
        listGridBagConstraints.gridy = 0;
        label.setFont(new Font("", Font.BOLD, 20));
        researchersList.add(label, listGridBagConstraints);
	
        listGridBagConstraints.gridx = 0;
        listGridBagConstraints.gridy = 1;

        researchersList.add(listContainer, listGridBagConstraints);
        
        listGridBagConstraints.gridx = 0;
        listGridBagConstraints.gridy = 2;
        viewButton.setBackground(blue);
        viewButton.setPreferredSize(new Dimension(150,30));
        listGridBagConstraints.anchor = listGridBagConstraints.EAST;
        researchersList.add(viewButton, listGridBagConstraints);       

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(researchersList, gridBagConstraints);    
        addDetailedContainer(new Researcher());
    }

	public ResearcherListContainer getListContainer() {
		return listContainer;
	}

	public void setListContainer(ResearcherListContainer listContainer) {
		this.listContainer = listContainer;
	}
	public void addDetailedContainer(Researcher selectedResearcher) {
		if(detailedContainer != null) {
			remove(detailedContainer);
		}
		detailedContainer = new ResearcherDetailedContainer(selectedResearcher);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(20, 0, 10, 0);
		add(detailedContainer, gridBagConstraints);
		SwingUtilities.updateComponentTreeUI(this);
		
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



}
