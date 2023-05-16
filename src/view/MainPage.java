package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;


import interfaces.IPage;
import model.Researcher;

public class MainPage extends JFrame implements IPage, java.util.Observer{

    private Researcher model;
    private Navbar navbar;
    private JPanel navbarPanel = new JPanel();
    private JPanel contentPanel = new JPanel();
	private Container container = getContentPane();
	private Component AccountPage;

    public MainPage( Researcher model) {
    	this.model = model;
    	this.navbar = new Navbar(model);
    	this.AccountPage = new AccountPage(model);
    	initComponents();
    }

    private void initComponents() {
    	container.setLayout(new GridBagLayout());
    	GridBagConstraints containerConstraints = new GridBagConstraints();    	
    	containerConstraints.fill = GridBagConstraints.HORIZONTAL;
    	containerConstraints.weighty = 1.0;  
    	containerConstraints.anchor = GridBagConstraints.PAGE_START; 
    	containerConstraints.gridx = 0;     
    	containerConstraints.gridy = 0; 
    	container.add(navbarPanel, containerConstraints);
    	containerConstraints.gridy = 1;
    	container.add(contentPanel, containerConstraints);
    	setHeading();
    	setContent(new AccountPage(model));
		this.pack();
		this.setTitle("Main Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("update/ mainpage");
		
	}
    
	
    public void setModel(Researcher model) {
    	System.out.println("Model set!!!");
    	this.model= model;
    }

    public Navbar getNavbar() {
		return navbar;
	}

	public void setNavbar(Navbar navbar) {
		this.navbar = navbar;
	}


	@Override
	public void setHeading() {
		//removeAll();
		navbarPanel.add(navbar);
		//repaint();
		//revalidate();	
	}

	@Override
	public void setContent(Component page) {
		System.out.println("set content in mainpage");

		contentPanel.removeAll();
		contentPanel.add(page);	
		contentPanel.repaint();
		contentPanel.revalidate();	
	}

	/*public void showAccountPage(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
		
	}*/
	
}
