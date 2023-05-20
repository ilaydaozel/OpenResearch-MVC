package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import model.Researcher;

public class AccountPage extends JPanel implements java.util.Observer{

    private Researcher researcher;
    private JLabel label = new JLabel("Account page" );
    private JLabel usernameLabel = new JLabel("Username:", SwingConstants.RIGHT);
    private JLabel username;
	private JLabel followerLabel = new JLabel("Follower Researchers:");
	private JLabel followingLabel = new JLabel("Following Researchers:");
    private ListContainer followingList;
    private ListContainer followerList;
    private Color blue = new Color(144, 219, 244);
    
    public AccountPage( Researcher researcher) {
    	this.researcher = researcher;
    	researcher.addObserver(this);
    	initComponents();
    }

    private void initComponents() {
    	username = new JLabel(researcher.getUsername(), SwingConstants.RIGHT);
		followerList = new ListContainer(researcher.getFollowerResearchers(), 250, 70);
		followingList = new ListContainer(researcher.getFollowingResearchers(), 250, 70);
    	
    	//panel design
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        //label
        usernameLabel.setFont(new Font("", Font.BOLD, 18));
        usernameLabel.setForeground(blue);
        username.setFont(new Font("", Font.PLAIN, 16));
    	username.setVerticalAlignment(SwingConstants.BOTTOM);
    	
        //nameInfoPanel
        JPanel nameInfoPanel = new JPanel();
    	
        nameInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        nameInfoPanel.setBackground(Color.white);;
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
        GridBagConstraints followGridBagConstraints = new GridBagConstraints();
        //follower panel
        JPanel followerPanel = new JPanel();
        followerPanel.setLayout(new BoxLayout(followerPanel, BoxLayout.Y_AXIS));
        followerLabel.setFont(new Font("", getFont().getStyle(),16));
        followerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        followerList.setAlignmentX(Component.LEFT_ALIGNMENT);
        followerPanel.add(followerLabel);
        followerPanel.add(followerList);
        
        //following panel
        JPanel followingPanel = new JPanel();
        followingPanel.setLayout(new BoxLayout(followingPanel, BoxLayout.Y_AXIS));
        followingLabel.setFont(new Font("", getFont().getStyle(),16));
        followingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        followingList.setAlignmentX(Component.LEFT_ALIGNMENT);
        followingPanel.add(followingLabel);
        followingPanel.add(followingList);
        
        followGridBagConstraints.gridx = 0;
        followGridBagConstraints.gridy = 0;
        followGridBagConstraints.insets = new Insets(15, 5, 15, 5);
        followPanel.add(followerPanel, followGridBagConstraints );
        
        followGridBagConstraints.gridx = 1;
        followGridBagConstraints.gridy = 0;
        followGridBagConstraints.insets = new Insets(15, 5, 15, 5);
        followPanel.add(followingPanel, followGridBagConstraints );
        
        Border followPanelBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        followPanel.setBorder(followPanelBorder);

 
        //add follow panel
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(followPanel, gridBagConstraints);

        
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("********inside update method accountpage");
		System.out.println(researcher.getFollowingResearchers());
		System.out.println("--------------updated Accountpage----------");
		
	}
   
}
