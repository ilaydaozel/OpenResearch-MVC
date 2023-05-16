package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;

import interfaces.IPage;
import model.Researcher;

public class AccountPage extends JPanel implements java.util.Observer{

    private Researcher model;
    private JLabel label = new JLabel("Account page");
    //private Container container = getContentPane();

    public AccountPage( Researcher model) {
    	this.model = model;
    	//this.navbar = new Navbar(model);
    	initComponents();
    }

    private void initComponents() {

    	setBackground(new Color(255,255,255));
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        add(label, gridBagConstraints);


    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("update/ mainpage");
		
	}
   
}
