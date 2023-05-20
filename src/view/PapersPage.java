package view;

import javax.swing.*;
import javax.swing.border.Border;

import model.Article;
import model.Collection;
import model.Paper;
import model.PaperCollection;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class PapersPage extends JPanel implements java.util.Observer {
	private Collection paperCollection;
    private List<Object> paperList;
    private ListWrapper paperListWrapper;
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private JPanel detailedContainer = new JPanel();
	private Paper _paper ;
	private JLabel paperTitleLabel = new JLabel("Book Title:");
	private JLabel paperTitle;
    private Color blue = new Color(144, 219, 244);
    private JButton downloadButton = new JButton("Download File");
    
    public PapersPage(Collection paperCollection) {
    	this.paperCollection = paperCollection;
    	this.paperList = paperCollection.getCollection();
    	this.paperListWrapper = new ListWrapper("Papers", paperList, 700, 100);
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
		//get info of paper
        this.paperTitle = new JLabel(selectedPaper.getTitle());
		detailedContainer.removeAll();
		
		//detailed Container
		detailedContainer.setBackground(Color.white);
		detailedContainer.setPreferredSize(new Dimension(900,300));
		detailedContainer.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        //paper title panel
        JPanel paperTitlePanel = new JPanel();
        paperTitlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        paperTitlePanel.setBackground(Color.white);
        paperTitlePanel.add(paperTitleLabel);
        paperTitlePanel.add(paperTitle);
        
        paperTitleLabel.setAlignmentY(BOTTOM_ALIGNMENT);
        paperTitle.setAlignmentY(BOTTOM_ALIGNMENT);
        Border paperTitleBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        paperTitlePanel.setBorder(paperTitleBorder);
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        detailedContainer.add(paperTitlePanel, gridBagConstraints);
    
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
