package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionListener;

import model.Article;
import model.Collection;
import model.ConferencePaper;
import model.Paper;
import model.PaperCollection;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class PapersPage extends JPanel implements java.util.Observer {
	private Collection paperCollection;
    private List<Object> paperList;
    private ListContainer listContainer; 
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private JPanel detailedContainer = new JPanel();
	private Paper _paper ;
    private Color blue = new Color(144, 219, 244);
    private JButton downloadButton = new JButton("Download File");
    
    public PapersPage(Collection paperCollection) {
    	this.paperCollection = paperCollection;
    	this.paperList = paperCollection.getCollection();
		this.listContainer = new ListContainer(paperList, 700, 100);
    	initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
    	JLabel pageLabel = new JLabel("PAPERS");
    	pageLabel.setFont(new Font("", Font.BOLD, 20));
    	pageLabel.setForeground(blue);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(pageLabel,gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(listContainer, gridBagConstraints);    
        addDetailedContainer(new Article());
    }

	public void addDetailedContainer(Paper selectedPaper) {
		detailedContainer.removeAll();
		
		//detailed Container
		detailedContainer.setBackground(Color.white);
		detailedContainer.setPreferredSize(new Dimension(800,300));
		detailedContainer.setLayout(new GridBagLayout());
        Border detailedContainerBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        detailedContainer.setBorder(detailedContainerBorder);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        //paper title panel
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        JPanel titlePanel = addInformationLine("Paper Title: ", selectedPaper.getTitle());
        detailedContainer.add(titlePanel, gridBagConstraints);
        //author panel
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        JPanel authorPanel = addInformationLine("Author(s): ", selectedPaper.getAuthors());
        detailedContainer.add(authorPanel, gridBagConstraints);
        //doi panel
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        JPanel doiPanel = addInformationLine("DOI: ", selectedPaper.getDoi());
        detailedContainer.add(doiPanel, gridBagConstraints);
        //year panel
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        JPanel yearPanel = addInformationLine("Year: ", selectedPaper.getYear());
        detailedContainer.add(yearPanel, gridBagConstraints);
        
        if( selectedPaper instanceof ConferencePaper) {
        	ConferencePaper conferencePaper = (ConferencePaper) selectedPaper;
            //book title panel
            gridBagConstraints.gridy = 4;
            gridBagConstraints.anchor = gridBagConstraints.WEST;
            JPanel bookTitlePanel = addInformationLine("Book Title: ", conferencePaper.getBookTitle());
            detailedContainer.add(bookTitlePanel, gridBagConstraints);
        }
        else if( selectedPaper instanceof Article) {
        	Article article = (Article) selectedPaper;
            //volume panel
            gridBagConstraints.gridy = 4;
            gridBagConstraints.anchor = gridBagConstraints.WEST;
            JPanel volumePanel = addInformationLine("Volume: ", article.getVolume());
            detailedContainer.add(volumePanel, gridBagConstraints);
            //number panel
            gridBagConstraints.gridy = 5;
            gridBagConstraints.anchor = gridBagConstraints.WEST;
            JPanel numberPanel = addInformationLine("Number: ", article.getNumber());
            detailedContainer.add(numberPanel, gridBagConstraints);
            //journal panel
            gridBagConstraints.gridy = 6;
            gridBagConstraints.anchor = gridBagConstraints.WEST;
            JPanel journalPanel = addInformationLine("Journal: ", article.getJournal());
            detailedContainer.add(journalPanel, gridBagConstraints);
        }
    
        //download button panel
        JPanel downloadButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        downloadButton.setBackground(blue);
        downloadButton.setPreferredSize(new Dimension(150,30));
        downloadButtonPanel.setBackground(Color.white);
        downloadButtonPanel.add(downloadButton);
        //download number panel
        JPanel downloadNumberPanel = addVerticalInfo("Download number: ", selectedPaper.getDownloadNumber()+"");
        downloadButtonPanel.add(downloadNumberPanel);
              
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(20, 0, 10, 0);
        detailedContainer.add(downloadButtonPanel, gridBagConstraints);

        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(20, 0, 10, 0);
		add(detailedContainer, gridBagConstraints);
		SwingUtilities.updateComponentTreeUI(this);
		
	}
	
	public JPanel addInformationLine(String title, String text) {
        JPanel infoLinePanel = new JPanel();
        JLabel infoLineLabel = new JLabel(title);
    	JLabel infoLineText = new JLabel(text);
    	infoLineLabel.setFont(new Font("", Font.PLAIN, 14));
    	infoLineText.setFont(new Font("", Font.ITALIC, 12));
        infoLinePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        infoLinePanel.setPreferredSize(new Dimension(700,25));
        infoLinePanel.setBackground(Color.white);
        infoLinePanel.add(infoLineLabel);
        infoLinePanel.add(infoLineText);
        Border infoLineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        infoLinePanel.setBorder(infoLineBorder);
        return infoLinePanel;
	}
	
	public JPanel addVerticalInfo(String title, String text) {
		JPanel verticalPanel = new JPanel();
        JLabel titleLabel = new JLabel(title);
        JLabel textLabel = new JLabel(text);
		verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalPanel.add(titleLabel);
        verticalPanel.add(textLabel);
        return verticalPanel;
	}
	
    public void downloadFile(ActionListener actionListener) {
        downloadButton.addActionListener(actionListener);
    }
    
    @Override
    public void update(java.util.Observable o, Object arg) {
		// TODO Auto-generated method stub
    }
	
	public void selectPaper(ListSelectionListener listSelectionListener) {
		listContainer.getList().addListSelectionListener(listSelectionListener);
    }
	public List<Object> getPaperList() {
		return paperList;
	}

	public void setPaperList(List<Object> paperList) {
		this.paperList = paperList;
	}

	public ListContainer getListContainer() {
		return listContainer;
	}

	public void setListContainer(ListContainer listContainer) {
		this.listContainer = listContainer;
	}



}
