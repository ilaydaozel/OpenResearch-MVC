
package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;

import interfaces.IPage;
import model.Paper;


public class PapersPage extends JPanel implements java.util.Observer{
	 private JLabel label = new JLabel("Papers Page");
    private JButton viewButton = new JButton("View more");
    private PaperListContainer listContainer = new PaperListContainer();
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private Color blue = new Color(144, 219, 244);

    public PapersPage() {
    	initComponents();
    }

    private void initComponents() {

    	setLayout(new GridBagLayout());
        
        JPanel papersList = new JPanel();
        papersList.setLayout(new GridBagLayout());
        GridBagConstraints listGridBagConstraints = new GridBagConstraints();

        listGridBagConstraints.gridx = 0;
        listGridBagConstraints.gridy = 0;
        label.setFont(new Font("", Font.BOLD, 20));
        papersList.add(label, listGridBagConstraints);
	
        listGridBagConstraints.gridx = 0;
        listGridBagConstraints.gridy = 1;

        papersList.add(listContainer, listGridBagConstraints);
        
        listGridBagConstraints.gridx = 0;
        listGridBagConstraints.gridy = 2;
        viewButton.setBackground(blue);
        viewButton.setPreferredSize(new Dimension(150,30));
        listGridBagConstraints.anchor = listGridBagConstraints.EAST;
        papersList.add(viewButton, listGridBagConstraints);       

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(papersList, gridBagConstraints);    

    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("update/ mainpage");
		
	}
	
	 public void selectPaper(ActionListener actionListener) {
	    	viewButton.addActionListener(actionListener);
	    }

		public JButton getViewButton() {
			return viewButton;
		}

		public void setViewButton(JButton viewButton) {
			this.viewButton = viewButton;
		}
   
}