
package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;
import model.Researcher;


public class ResearchersPage extends JPanel implements java.util.Observer{
    private ResearcherDetailedContainer detailedContainer;
    private ResearcherListWrapper researcherListWrapper = new ResearcherListWrapper();
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private Researcher model;

    public ResearchersPage(Researcher model) {
    	this.model = model;
    	initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(researcherListWrapper, gridBagConstraints);    
        addDetailedContainer(new Researcher("", ""));
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
	
    public ResearcherListWrapper getResearcherListWrapper() {
		return researcherListWrapper;
	}

	public void setResearcherListWrapper(ResearcherListWrapper researcherListWrapper) {
		this.researcherListWrapper = researcherListWrapper;
	}

	public void selectResearcher(ActionListener actionListener) {
    	researcherListWrapper.getViewButton().addActionListener(actionListener);
    }

	public ResearcherDetailedContainer getDetailedContainer() {
		return detailedContainer;
	}

	public void setDetailedContainer(ResearcherDetailedContainer detailedContainer) {
		this.detailedContainer = detailedContainer;
	}

	public Researcher getModel() {
		return model;
	}

	public void setModel(Researcher model) {
		this.model = model;
	}



}
