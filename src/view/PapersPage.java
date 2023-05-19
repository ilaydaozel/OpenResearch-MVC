package view;

import javax.swing.*;

import model.Article;
import model.Paper;
import model.PaperCollection;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class PapersPage extends JPanel implements java.util.Observer {
    private List<Object> paperList =  new PaperCollection().getCollection();
    private ListWrapper paperListWrapper = new ListWrapper("Papers", paperList, 700, 100);
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private JPanel detailedContainer = new JPanel();
	private Paper _paper ;
	private JLabel bookLabel = new JLabel("Book Title:");
	private JLabel bookTitle = new JLabel();
    private Color blue = new Color(144, 219, 244);
    private JButton downloadButton = new JButton("Download File");
    //private Researcher model;
    
    public PapersPage() {
    	//this.model = model;
    	initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(paperListWrapper, gridBagConstraints);    
        addDetailedContainer(new Article("", "", "", "", "", "", "", 0));
    }

	public void addDetailedContainer(Paper selectedPaper) {
		detailedContainer.removeAll();
		detailedContainer.setBackground(Color.white);
		detailedContainer.setPreferredSize(new Dimension(900,300));
		detailedContainer.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        JPanel bookTitlePanel = new JPanel();
        bookTitlePanel.setLayout(new FlowLayout());
        bookTitlePanel.setBackground(Color.white);
        bookTitlePanel.add(bookLabel);
        bookTitlePanel.add(new JLabel(selectedPaper.getTitle()));
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        detailedContainer.add(bookTitlePanel, gridBagConstraints);
    
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.white);
        buttonPanel.add(downloadButton);
     
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        detailedContainer.add(buttonPanel, gridBagConstraints); 
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(20, 0, 10, 0);
		add(detailedContainer, gridBagConstraints);
		SwingUtilities.updateComponentTreeUI(this);
		
	}
	
    public void downloadFile(ActionListener actionListener) {
        downloadButton.addActionListener(actionListener);
    }
    
    @Override
    public void update(java.util.Observable o, Object arg) {
		// TODO Auto-generated method stub
    }
	public void selectPaper(ActionListener actionListener) {
    	paperListWrapper.getViewButton().addActionListener(actionListener);
    }

	public List<Object> getPaperList() {
		return paperList;
	}

	public void setPaperList(List<Object> paperList) {
		this.paperList = paperList;
	}


	public ListWrapper getPaperListWrapper() {
		return paperListWrapper;
	}

	public void setPaperListWrapper(ListWrapper paperListWrapper) {
		this.paperListWrapper = paperListWrapper;
	}


}
