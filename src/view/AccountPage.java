package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

import model.Researcher;

public class AccountPage extends JPanel implements java.util.Observer{

    private Researcher researcher;
    private JLabel label = new JLabel("Account page" );
    private JLabel usernameLabel = new JLabel("Username:", SwingConstants.RIGHT);
    private JLabel username;
	private JLabel followerLabel = new JLabel("Follower Researchers:");
	private JLabel followingLabel = new JLabel("Following Researchers:");
    private JList followingList;
    private JList followerList;
    private JTextField newRLName = new JTextField(20);
    private JButton createRLButton = new JButton("Create Reading List");
    private Color blue = new Color(144, 219, 244);
    
    public AccountPage( Researcher researcher) {
    	this.researcher = researcher;
    	researcher.addObserver(this);
    	initComponents();
    }

    private void initComponents() {
    	username = new JLabel(researcher.getUsername(), SwingConstants.RIGHT);
 
    	//panel design
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        //follower list
        followerList = new JList(researcher.getFollowerResearchers().toArray());
        followerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        followerList.setLayoutOrientation(JList.VERTICAL);
        followerList.setVisibleRowCount(-1);
        JScrollPane followerListScroller = new JScrollPane(followerList);  
        followerListScroller.setPreferredSize(new Dimension(200,70));
        
        //following list
        followingList = new JList(researcher.getFollowingResearchers().toArray());
        followingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        followingList.setLayoutOrientation(JList.VERTICAL);
        followingList.setVisibleRowCount(-1);
        JScrollPane followingListScroller = new JScrollPane(followingList);  
        followingListScroller.setPreferredSize(new Dimension(200,70));
        
        //label
        usernameLabel.setFont(new Font("", Font.BOLD, 18));
        usernameLabel.setForeground(blue);
        username.setFont(new Font("", Font.PLAIN, 16));
    	username.setVerticalAlignment(SwingConstants.BOTTOM);
    	
        //nameInfoPanel
        JPanel nameInfoPanel = new JPanel();
    	
        nameInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        nameInfoPanel.setBackground(Color.white);
        nameInfoPanel.add(usernameLabel);
        nameInfoPanel.add(username);
        username.setAlignmentY(BOTTOM_ALIGNMENT);
        usernameLabel.setAlignmentY(BOTTOM_ALIGNMENT);;
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        nameInfoPanel.setBorder(border);
        
        //add nameInfoPanel
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 0, 20, 0);
        add(nameInfoPanel, gridBagConstraints);
        
        //follow panel
        JPanel followPanel = new JPanel();
        followPanel.setLayout(new GridBagLayout());
        followPanel.setPreferredSize(new Dimension(600,150));
        GridBagConstraints followGridBagConstraints = new GridBagConstraints();
        //follower panel
        JPanel followerPanel = new JPanel();
        followerPanel.setLayout(new BoxLayout(followerPanel, BoxLayout.Y_AXIS));
        followerLabel.setFont(new Font("", getFont().getStyle(),16));
        followerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        followerListScroller.setAlignmentX(Component.LEFT_ALIGNMENT);
        followerPanel.add(followerLabel);
        followerPanel.add(followerListScroller);
        
        //following panel
        JPanel followingPanel = new JPanel();
        followingPanel.setLayout(new BoxLayout(followingPanel, BoxLayout.Y_AXIS));
        followingLabel.setFont(new Font("", getFont().getStyle(),16));
        followingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        followingListScroller.setAlignmentX(Component.LEFT_ALIGNMENT);
        followingPanel.add(followingLabel);
        followingPanel.add(followingListScroller);
        
        followGridBagConstraints.gridx = 0;
        followGridBagConstraints.gridy = 0;
        followGridBagConstraints.insets = new Insets(15, 10, 15, 5);
        followPanel.add(followerPanel, followGridBagConstraints );
        
        followGridBagConstraints.gridx = 1;
        followGridBagConstraints.gridy = 0;
        followGridBagConstraints.insets = new Insets(15, 10, 15, 5);
        followPanel.add(followingPanel, followGridBagConstraints );
        
        Border followPanelBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        followPanel.setBorder(followPanelBorder);

 
        //add follow panel
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(followPanel, gridBagConstraints);
        
        //readingList panel
        JPanel readingListPanel = new JPanel();
        readingListPanel.setLayout(new GridBagLayout());
        readingListPanel.setPreferredSize(new Dimension(600,200));
        GridBagConstraints rlGridBagConstraints = new GridBagConstraints();
        Border rlPanelBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        readingListPanel.setBorder(rlPanelBorder);
        readingListPanel.add(new JLabel("New reading list name:  "));
        readingListPanel.add(newRLName);
        readingListPanel.add(createRLButton);
        
        //ad readingList panel
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(readingListPanel, gridBagConstraints);

    }

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("********inside update method accountpage");
		followerList.setListData(researcher.getFollowerResearchers().toArray());
		followingList.setListData(researcher.getFollowingResearchers().toArray());
		
	}
    
    public void createNewReadingList(ActionListener actionListener) {
    	createRLButton.addActionListener(actionListener);
    }
   
}
