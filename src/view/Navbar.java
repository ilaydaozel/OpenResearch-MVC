
package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.Researcher;
import store.UserStore;

public class Navbar extends JPanel {
	private JPanel navbar = new JPanel();
    private JButton accountButton = new JButton("My Account");
    private JButton papersButton = new JButton("Papers");
    private JButton researchersButton = new JButton("Researchers");
    private JButton logoutButton = new JButton("Log out");  
    private JLabel name;
    private UserStore userStore ;
    private Color blue = new Color(144, 219, 244);

    public Navbar( UserStore session) {
    	this.userStore = session;
    	initComponents();
    }

    private void initComponents() {
    	papersButton.setPreferredSize(new Dimension(200, 30));
    	papersButton.setBackground(blue);
    	researchersButton.setPreferredSize(new Dimension(200, 30));
    	researchersButton.setBackground(blue);
    	accountButton.setPreferredSize(new Dimension(200, 30));
    	accountButton.setBackground(blue);
    	logoutButton.setPreferredSize(new Dimension(80, 30));
    	logoutButton.setForeground(Color.WHITE);
    	logoutButton.setBackground(Color.gray);

    	setLayout(new GridBagLayout());
    	setBackground(Color.white);
    	GridBagConstraints pageConstraints = new GridBagConstraints();    	
    	navbar.setLayout(new GridBagLayout());
    	name = new JLabel("Welcome "+ userStore.getUser().getUsername()+ " !");
    	name.setFont(new Font("", Font.BOLD, 16));
		GridBagConstraints navbarConstraints = new GridBagConstraints();
		//pageConstraints.fill = GridBagConstraints.PAGE_START;
    	navbar.add(papersButton, navbarConstraints);
    	navbarConstraints.gridx = 1;
    	navbar.add(researchersButton, navbarConstraints);
    	navbarConstraints.gridx = 2;
    	navbar.add(accountButton, navbarConstraints);
    	navbarConstraints.gridx = 3;
    	navbar.add(logoutButton, navbarConstraints);
    	navbarConstraints.gridx = 4;
    	navbarConstraints.insets = new Insets(10, 10, 0, 10);
    	navbar.add(name, navbarConstraints);

    	pageConstraints.fill = GridBagConstraints.HORIZONTAL;
    	pageConstraints.weighty = 1.0;  
    	pageConstraints.anchor = GridBagConstraints.PAGE_START; 
    	pageConstraints.gridx = 0;     
    	pageConstraints.gridy = 0;       
        add(navbar, pageConstraints);

    }

    public void navigate(ActionListener actionListener) {
    	System.out.println("press button in navbar");
    	researchersButton.addActionListener(actionListener);
    	papersButton.addActionListener(actionListener);
    	accountButton.addActionListener(actionListener);
    }
 
    public void logout(ActionListener actionListener) {
    	System.out.println("logout / mainpage");
    	logoutButton.addActionListener(actionListener);
    }

	public UserStore getUserStore() {
		return userStore;
	}

	public void setUserStore(UserStore userStore) {
		this.userStore = userStore;
	}
    
    
}
    