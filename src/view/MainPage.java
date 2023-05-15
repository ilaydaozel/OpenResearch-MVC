package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;


import model.Researcher;

public class MainPage extends JFrame implements java.util.Observer{
	private JPanel navbar = new JPanel();
    private JButton accountButton = new JButton("My Account");
    private JButton paperListButton = new JButton("Paper List");
    private JButton researcherListButton = new JButton("Researcher List");
    private JButton logoutButton = new JButton("Log out");
    private Font bigFont = new Font("", Font.BOLD, 18);    
    private Color blue = new Color(144, 219, 244);
    private Color white = new Color(255, 255, 255);
    private Researcher model;

    private Container container = getContentPane();

    public MainPage( Researcher model) {
    	this.model = model;
    	initComponents();
    }

    private void initComponents() {
    	container.setBackground(white);
    	paperListButton.setPreferredSize(new Dimension(200, 30));
    	paperListButton.setBackground(blue);
    	researcherListButton.setPreferredSize(new Dimension(200, 30));
    	researcherListButton.setBackground(blue);
    	accountButton.setPreferredSize(new Dimension(200, 30));
    	accountButton.setBackground(blue);
    	logoutButton.setPreferredSize(new Dimension(200, 30));
    	logoutButton.setBackground(blue);
    	System.out.println("model in main page: "+ model.getName());
        JLabel name = new JLabel("User: "+ model.getName());
    	setPreferredSize(new Dimension(1000,600));
    	setLayout(new GridBagLayout());
    	GridBagConstraints pageConstraints = new GridBagConstraints();    	
    	navbar.setLayout(new GridBagLayout());

		GridBagConstraints navbarConstraints = new GridBagConstraints();
		//pageConstraints.fill = GridBagConstraints.PAGE_START;
    	navbar.add(paperListButton, navbarConstraints);
    	navbarConstraints.gridx = 1;
    	navbar.add(researcherListButton, navbarConstraints);
    	navbarConstraints.gridx = 2;
    	navbar.add(accountButton, navbarConstraints);
    	navbarConstraints.gridx = 3;
    	navbar.add(logoutButton, navbarConstraints);
    	navbarConstraints.gridx = 4;
    	navbar.add(name, navbarConstraints);

    	pageConstraints.fill = GridBagConstraints.HORIZONTAL;
    	pageConstraints.weighty = 1.0;  
    	pageConstraints.anchor = GridBagConstraints.PAGE_START; 
    	pageConstraints.gridx = 0;     
    	pageConstraints.gridy = 0;       
        add(navbar, pageConstraints);

		this.pack();
		this.setTitle("Main Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("update/ mainpage");
		
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
