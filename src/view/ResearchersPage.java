
package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionListener;

import model.Collection;
import model.Researcher;
import model.ResearcherCollection;


public class ResearchersPage extends JPanel implements java.util.Observer{
	private Collection researcherCollection;
    private List<Object> researcherList;
    private ListContainer listContainer; 
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private JPanel detailedContainer = new JPanel();
	private JLabel usernameLabel = new JLabel("User:");
	private JLabel username = new JLabel();
	private JButton followButton = new JButton("Follow");
	private JButton unfollowButton = new JButton("Unfollow");
    private Color blue = new Color(144, 219, 244);

    
    public ResearchersPage(Collection researcherCollection) {
    	this.researcherCollection = researcherCollection;
    	this.researcherList = researcherCollection.getCollection();
		this.listContainer = new ListContainer(researcherList, 500, 100);
    	researcherCollection.addObserver(this);
    	initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
    	JLabel pageLabel = new JLabel("RESEARCHERS");
    	pageLabel.setFont(new Font("", Font.BOLD, 20));
    	pageLabel.setForeground(blue);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(pageLabel,gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(listContainer, gridBagConstraints);    
        addDetailedContainer(new Researcher());
    }

	public void addDetailedContainer(Researcher selectedResearcher) {
		detailedContainer.removeAll();

		detailedContainer.setBackground(Color.white);
		detailedContainer.setPreferredSize(new Dimension(800,300));
		detailedContainer.setLayout(new GridBagLayout());
        Border detailedContainerBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        detailedContainer.setBorder(detailedContainerBorder);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        JPanel nameInfoPanel = new JPanel();
        nameInfoPanel.setPreferredSize(new Dimension(200,40));
        usernameLabel.setFont(new Font("", Font.BOLD, 20));
        usernameLabel.setForeground(blue);
        username.setFont(new Font("", Font.PLAIN, 18));
    	username.setVerticalAlignment(SwingConstants.CENTER);
        nameInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        nameInfoPanel.setBackground(Color.white);
        nameInfoPanel.add(usernameLabel);
        nameInfoPanel.add(new JLabel(selectedResearcher.getUsername()));
        username.setAlignmentY(BOTTOM_ALIGNMENT);
        usernameLabel.setAlignmentY(BOTTOM_ALIGNMENT);;
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        nameInfoPanel.setBorder(border);
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        detailedContainer.add(nameInfoPanel, gridBagConstraints);
        
        //buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(350, 40));
        buttonPanel.setBackground(Color.white);
        //follow button
        followButton.setBackground(blue);
        followButton.setPreferredSize(new Dimension(150,30));
        buttonPanel.add(followButton);
        //unfollow button
        unfollowButton.setBackground(blue);
        unfollowButton.setPreferredSize(new Dimension(150,30));
        buttonPanel.add(unfollowButton);
        //add button panel to panel
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        detailedContainer.add(buttonPanel, gridBagConstraints); 

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(20, 0, 10, 0);
		add(detailedContainer, gridBagConstraints);
		SwingUtilities.updateComponentTreeUI(this);
		
	}
	
    public void followResearcher(ActionListener actionListener) {
    	followButton.addActionListener(actionListener);

    }
    
    public void unfollowResearcher(ActionListener actionListener) {
    	unfollowButton.addActionListener(actionListener);
    }
    
    public void refresh() {
    	System.out.println();
    	SwingUtilities.updateComponentTreeUI(this);
    }
    
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("updated researcher");
		// TODO Auto-generated method stub
	}
	
	public void selectResearcher(ListSelectionListener listSelectionListener) {
		listContainer.getList().addListSelectionListener(listSelectionListener);
    }

	public ListContainer getListContainer() {
		return listContainer;
	}

	public void setListContainer(ListContainer listContainer) {
		this.listContainer = listContainer;
	}


}
