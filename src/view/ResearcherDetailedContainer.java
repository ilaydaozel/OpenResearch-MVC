
package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import model.Researcher;
import model.ResearcherCollection;

@SuppressWarnings("serial")
public class ResearcherDetailedContainer extends JPanel implements Observer {
	private Researcher model ;
	private JLabel usernameLabel = new JLabel("User:");
	private JLabel username = new JLabel();
	private JLabel followerLabel = new JLabel("Followers:");
	private JLabel followingLabel = new JLabel("Followings:");
	private JButton followButton = new JButton("Follow");
	private JButton unfollowButton = new JButton("Unfollow");
	private FollowListContainer followerList;
	private FollowListContainer followingList;
    private Color blue = new Color(144, 219, 244);
	
    public ResearcherDetailedContainer(Researcher researcher) {
    	this.model = researcher;
    	this.followerList = new FollowListContainer(researcher.getFollowerResearchers());
    	this.followingList = new FollowListContainer(researcher.getFollowingResearchers());
    	username.setText(researcher.getUsername());
    	initComponents();
    }
    
    private void initComponents() {
    	setBackground(Color.white);
    	setPreferredSize(new Dimension(600,200));
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new FlowLayout());
        usernamePanel.setBackground(Color.white);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(new JLabel(model.getUsername()));
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        add(usernamePanel, gridBagConstraints);
    
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
        add(followPanel, gridBagConstraints);
        
        
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
        add(buttonPanel, gridBagConstraints); 

    }
    public void followResearcher(ActionListener actionListener) {
    	followButton.addActionListener(actionListener);
    	SwingUtilities.updateComponentTreeUI(this);
    	System.out.println(model.getFollowingResearchers());
    }
    public void unfollowResearcher(ActionListener actionListener) {
    	unfollowButton.addActionListener(actionListener);
    	SwingUtilities.updateComponentTreeUI(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}


}