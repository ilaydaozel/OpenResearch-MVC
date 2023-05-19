package view;

import model.Researcher;
import model.ResearcherCollection;
import store.UserStore;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPage extends JFrame implements java.util.Observer {    
    private JLabel pageLabel = new JLabel("Welcome to OpenResearch!");
    private JLabel usernameLabel = new JLabel("Username");
    private JLabel passLabel = new JLabel("Password");
    private JTextField usernameInput  = new JTextField(20);
    private JTextField passInput = new JTextField(20);
    private JButton loginButton = new JButton("Login");
    private Font bigFont = new Font("", Font.BOLD, 18);
    private Color blue = new Color(144, 219, 244);
    private Color white = new Color(255, 255, 255);
    private Container container = getContentPane();
    private Researcher model;


    public LoginPage() {
    	initComponents();
    }

    public Researcher getModel() {
		return model;
	}

	public void setModel(Researcher model) {
		this.model = model;
	}

	private void initComponents() {
    	container.setBackground(white);
		loginButton.setPreferredSize(new Dimension(240, 40));
		loginButton.setBackground(blue);
		
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
        pageLabel.setForeground(blue);
        gridBagConstraints.insets = labelInset;
        add(pageLabel, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(usernameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        usernameInput.setText("İlayda");
        add(usernameInput, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(passLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        passInput.setText("123");

        add(passInput, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = buttonInset;
        
        add(loginButton, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        
		this.pack();
		this.setTitle("Welcome to OpenResearch");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
	public String getUsernameInput() {
		return this.usernameInput.getText();
	}
	public String getPasswordInput() {
		return this.passInput.getText();
	}

	public void login(ActionListener actionListener) {
    	loginButton.addActionListener(actionListener);
    }
    
	@Override
	public void update(java.util.Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
	
	public void changeToErrorPage() {
		 JOptionPane.showMessageDialog(this, "Please enter a valid email and password", "Error", JOptionPane.ERROR_MESSAGE);
		
	}
	
	
    



}
