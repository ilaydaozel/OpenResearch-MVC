
package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import javax.swing.*;

import model.Collection;
import model.Researcher;
import model.ResearcherCollection;


public class ResearchersPage extends JPanel implements java.util.Observer{
	private Collection researcherCollection;
    private List<Object> researcherList;
    private ListWrapper researcherListWrapper;
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private JPanel detailedContainer = new JPanel();
    //private Researcher model;
	private JLabel usernameLabel = new JLabel("User:");
	private JLabel username = new JLabel();
	private JLabel followerLabel = new JLabel("Followers:");
	private JLabel followingLabel = new JLabel("Followings:");
	private JButton followButton = new JButton("Follow");
	private JButton unfollowButton = new JButton("Unfollow");
    private Color blue = new Color(144, 219, 244);
    private ListContainer followingList;
    private ListContainer followerList;
    
    public ResearchersPage(Collection researcherCollection) {
    	this.researcherCollection = researcherCollection;
    	this.researcherList = researcherCollection.getCollection();
    	this.researcherListWrapper = new ListWrapper("Researchers", researcherList,500, 100);
    	researcherCollection.addObserver(this);
    	//this.model = model;
    	initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(researcherListWrapper, gridBagConstraints);    
        addDetailedContainer(new Researcher());
    }

	public void addDetailedContainer(Researcher selectedResearcher) {
		detailedContainer.removeAll();
		followerList = new ListContainer(selectedResearcher.getFollowerResearchers(), 200, 50);
		followingList = new ListContainer(selectedResearcher.getFollowingResearchers(), 200, 50);
		detailedContainer.setBackground(Color.white);
		detailedContainer.setPreferredSize(new Dimension(900,300));
		detailedContainer.setLayout(new GridBagLayout());
		
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new FlowLayout());
        usernamePanel.setBackground(Color.white);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(new JLabel(selectedResearcher.getUsername()));
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        detailedContainer.add(usernamePanel, gridBagConstraints);
    
        JPanel followPanel = new JPanel();
        followPanel.setLayout(new FlowLayout()); 
        followPanel.setBackground(Color.white);
        
        JPanel followerPanel = new JPanel();
        followerPanel.setLayout(new FlowLayout());
        followerPanel.setBackground(Color.white);
        followerPanel.add(followerLabel);
        followerPanel.add(followerList);
        
        JPanel followingPanel = new JPanel();
        followingPanel.setLayout(new FlowLayout());
        followingPanel.setBackground(Color.white);
        followingPanel.add(followingLabel);
        followingPanel.add(followingList);
        
        followPanel.add(followerPanel);
        followPanel.add(followingPanel);
 
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        detailedContainer.add(followPanel, gridBagConstraints);
        
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.white);
        followButton.setBackground(Color.white);
        followButton.setPreferredSize(new Dimension(100,20));
        buttonPanel.add(followButton);
       
        unfollowButton.setBackground(Color.white);
        unfollowButton.setPreferredSize(new Dimension(100,20));
        buttonPanel.add(unfollowButton);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        detailedContainer.add(buttonPanel, gridBagConstraints); 

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(20, 0, 10, 0);
		add(detailedContainer, gridBagConstraints);
		SwingUtilities.updateComponentTreeUI(this);
		
	}
	
    public void followResearcher(ActionListener actionListener) {
    	followButton.addActionListener(actionListener);

    }
    
    public void unfollowResearcher(ActionListener actionListener) {
    	unfollowButton.addActionListener(actionListener);
    	SwingUtilities.updateComponentTreeUI(this);
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
	
    public ListWrapper getResearcherListWrapper() {
		return researcherListWrapper;
	}

	public void setResearcherListWrapper(ListWrapper researcherListWrapper) {
		this.researcherListWrapper = researcherListWrapper;
	}

	public void selectResearcher(ActionListener actionListener) {
    	researcherListWrapper.getViewButton().addActionListener(actionListener);
    }


}
