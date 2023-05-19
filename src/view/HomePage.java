package view;

import java.awt.*;
import java.util.Observable;

import javax.swing.*;


import interfaces.IPage;
import model.Researcher;
import store.UserStore;

public class HomePage extends JFrame implements IPage, java.util.Observer{

    private Researcher model;
    private Navbar navbar;
    private JPanel navbarPanel = new JPanel();
    private JPanel contentPanel = new JPanel();
	private Container container = getContentPane();

    public HomePage(Navbar navbar) {
    	this.model = UserStore.getUser();
    	this.navbar = navbar;
    	initComponents();
    }

    private void initComponents() {
    	setMinimumSize(new Dimension(1000, 600));
    	container.setLayout(new GridBagLayout());
    	GridBagConstraints containerConstraints = new GridBagConstraints();    	
    	containerConstraints.fill = GridBagConstraints.HORIZONTAL;
    	containerConstraints.weighty = 1.0;  
    	containerConstraints.anchor = GridBagConstraints.PAGE_START; 
    	containerConstraints.gridx = 0;     
    	containerConstraints.gridy = 0; 

    	container.add(navbarPanel, containerConstraints);
    	containerConstraints.gridy = 1;
    	containerConstraints.gridx = 0;     
    	containerConstraints.gridy = 1; 
    	contentPanel.add(new JLabel("Welcome to Homepage!"));
    	container.add(contentPanel, containerConstraints);
		navbarPanel.removeAll();
		navbarPanel.add(navbar);	
		navbarPanel.repaint();
		navbarPanel.revalidate();	

		this.pack();
		this.setTitle("Main Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
	
    public void setModel(Researcher model) {
    	this.model= model;
    }

    public Navbar getNavbar() {
		return navbar;
	}

	public void setNavbar(Navbar navbar) {
		this.navbar = navbar;
	}

	@Override
	public void changeContent(Component page) {
		contentPanel.removeAll();
		contentPanel.add(page);	
		contentPanel.repaint();
		contentPanel.revalidate();	
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
