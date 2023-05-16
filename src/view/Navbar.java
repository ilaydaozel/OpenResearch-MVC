
package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;

import interfaces.IPage;
import model.Researcher;

public class Navbar extends JPanel implements java.util.Observer{
	private JPanel navbar = new JPanel();
    private JButton accountButton = new JButton("My Account");
    private JButton papersButton = new JButton("Papers");
    private JButton researchersButton = new JButton("Researchers");
    private JButton logoutButton = new JButton("Log out");  
    private Color blue = new Color(144, 219, 244);
    JLabel name;
    private Researcher model;

    public Navbar( Researcher model) {
    	this.model = model;
    	initComponents();
    }

    private void initComponents() {
    	papersButton.setPreferredSize(new Dimension(200, 30));
    	papersButton.setBackground(blue);
    	researchersButton.setPreferredSize(new Dimension(200, 30));
    	researchersButton.setBackground(blue);
    	accountButton.setPreferredSize(new Dimension(200, 30));
    	accountButton.setBackground(blue);
    	logoutButton.setPreferredSize(new Dimension(200, 30));
    	logoutButton.setBackground(blue);

    	setLayout(new GridBagLayout());
    	GridBagConstraints pageConstraints = new GridBagConstraints();    	
    	navbar.setLayout(new GridBagLayout());
    	name = new JLabel("Welcome "+ model.getUsername()+ " !");
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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("update/ mainpage");
		
	}
    
    public void showAccountPage(ActionListener actionListener) {
    	accountButton.addActionListener(actionListener);
    }
    public void showResearchersPage(ActionListener actionListener) {
    	System.out.println("press researchers button in navbar");
    	researchersButton.addActionListener(actionListener);
    }
    public void showPapersPage(ActionListener actionListener) {
    	System.out.println("press researchers button in navbar");
    	papersButton.addActionListener(actionListener);
    }
    
    
    public void logout(ActionListener actionListener) {
    	System.out.println("logout / mainpage");
    	logoutButton.addActionListener(actionListener);
    }
	
    public void setModel(Researcher model) {
    	System.out.println("Model set!!!");
    	this.model= model;
    }
}
    