package view;

import model.Researcher;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import interfaces.Observable;
import interfaces.Observer;


public class LoginPage extends JFrame implements java.util.Observer {
    public static boolean isLoggedIn = false;
    
    private JLabel pageLabel = new JLabel("Welcome to OpenResearch!");
    private JLabel usernameLabel = new JLabel("Username");
    private JLabel passLabel = new JLabel("Password");
    private JTextField usernameInput  = new JTextField(20);
    private JTextField passInput = new JTextField(20);
    private JButton loginButton = new JButton("Login");
    private JButton tryButton = new JButton("deneme");
    private Font bigFont = new Font("", Font.BOLD, 18);
    private Color orange = new Color(251, 133, 0);
    private Researcher model;

    public LoginPage( Researcher model) {
    	this.model = model;
    	//this.model.addObserver(this);
    	initComponents();
    }
    private JLabel username = new JLabel("a");
    private void initComponents() {
    	
		loginButton.setPreferredSize(new Dimension(240, 40));
		loginButton.setBackground(orange);
		

        Insets fieldsInset = new Insets(0, 10, 10, 0);
        Insets buttonInset = new Insets(20,10,20,10);
        Insets labelInset = new Insets(10,10,10,10);
    	setLayout(new GridBagLayout());
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        pageLabel.setFont(bigFont);
        pageLabel.setForeground(orange);
        gridBagConstraints.insets = labelInset;
        add(pageLabel, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(usernameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;

        add(usernameInput, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(passLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;

        add(passInput, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = buttonInset;
        
        add(loginButton, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = buttonInset;
        
        add(tryButton, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = labelInset;
        /*username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });*/
        add(username, gridBagConstraints);
        
		this.pack();
		this.setTitle("Welcome to OpenResearch");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
    }
    
    public void pressButton(ActionListener actionListener) {
    	System.out.println("pressbutton loginpage");
    	tryButton.addActionListener(actionListener);
    }


    /*
	@Override
	public void update(Observable observable) {
		// TODO Auto-generated method stub
		System.out.println("update loginpage");
		String data = ((Researcher)observable).getName();
		
		this.username.setText(data);
		
	}*/
	public String getUsernameInput() {
		System.out.println("get username inp loginpage");
		return this.usernameInput.getText();
	}
	public String getPasswordInput() {
		System.out.println("get username inp loginpage");
		return this.passInput.getText();
	}

    public void login(ActionListener actionListener) {
    	System.out.println("login / loginpage");
    	loginButton.addActionListener(actionListener);
    }

	@Override
	public void update(java.util.Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("update loginpage");
		String data = ((Researcher)o).getName();
		
		this.username.setText(data);
		
	}
    
    



}
