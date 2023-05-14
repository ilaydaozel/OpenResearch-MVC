package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Researcher;

public class AccountPage extends JFrame implements java.util.Observer{

    private JButton accountButton = new JButton("My Account");
    private JButton paperListButton = new JButton("Paper List");
    private JButton researcherListButton = new JButton("Researcher List");
    private Font bigFont = new Font("", Font.BOLD, 18);
    private Color orange = new Color(251, 133, 0);
    private Researcher model;

    public AccountPage( Researcher model) {
    	this.model = model;
    	//this.model.addObserver(this);
    	initComponents();
    }

    private void initComponents() {
    	
    	paperListButton.setPreferredSize(new Dimension(240, 40));
    	paperListButton.setBackground(orange);
    	researcherListButton.setPreferredSize(new Dimension(240, 40));
    	researcherListButton.setBackground(orange);
    	accountButton.setPreferredSize(new Dimension(240, 40));
    	accountButton.setBackground(orange);
    	

    	setLayout(new FlowLayout(15, 2, 5));
        add(paperListButton);
        add(researcherListButton);
        add(accountButton);

		this.pack();
		this.setTitle("My Account");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
    

}
