package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

import model.Article;
import model.Collection;
import model.ConferencePaper;
import model.Paper;
import model.PaperCollection;
import model.ReadingList;
import model.Researcher;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class PapersPage extends JPanel implements java.util.Observer {
	private Collection paperCollection;
    private List<Object> paperList;
    private ListContainer listContainer; 
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private JPanel detailedContainer = new JPanel();
    private JPanel detailedRLContainer = new JPanel();
	private Paper _paper ;
    private Color blue = new Color(144, 219, 244);
    private JButton downloadButton = new JButton("Download File");
    private JLabel downloadNum;
    private Paper selectedPaper = new Article();
    private JList rlList;
    private JTextField rLName = new JTextField(20);
    private JButton addToRLButton = new JButton("Add To This Reading List");
    private JButton removeFromRLButton = new JButton("Remove From This Reading List");
    private Researcher researcher;
    private ReadingList selectedReadingList;
    
    public PapersPage(Collection paperCollection, Researcher researcher) {
    	this.paperCollection = paperCollection;
    	this.paperList = paperCollection.getCollection();
    	this.researcher = researcher;
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
        addDetailedContainer(selectedPaper);
    }

	public void addDetailedContainer(Paper selectedPaper) {
		this.selectedPaper = selectedPaper;
		selectedPaper.deleteObserver(this);
		detailedContainer.removeAll();
		selectedPaper.addObserver(this);
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
        JPanel titlePanel = addInformationLine("Paper Title: ", selectedPaper.getTitle(), 700, 25);
        detailedContainer.add(titlePanel, gridBagConstraints);
        //author panel
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        JPanel authorPanel = addInformationLine("Author(s): ", selectedPaper.getAuthors() , 700, 25);
        detailedContainer.add(authorPanel, gridBagConstraints);
        //doi panel
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        JPanel doiPanel = addInformationLine("DOI: ", selectedPaper.getDoi(), 700, 25);
        detailedContainer.add(doiPanel, gridBagConstraints);
        //year panel
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        JPanel yearPanel = addInformationLine("Year: ", selectedPaper.getYear(), 700, 25);
        detailedContainer.add(yearPanel, gridBagConstraints);
        
        if( selectedPaper instanceof ConferencePaper) {
        	ConferencePaper conferencePaper = (ConferencePaper) selectedPaper;
            //book title panel
            gridBagConstraints.gridy = 4;
            gridBagConstraints.anchor = gridBagConstraints.WEST;
            JPanel bookTitlePanel = addInformationLine("Book Title: ", conferencePaper.getBookTitle(), 700, 25);
            detailedContainer.add(bookTitlePanel, gridBagConstraints);
        }
        else if( selectedPaper instanceof Article) {
        	Article article = (Article) selectedPaper;
        	
        	JPanel threePanel = new JPanel(new FlowLayout());
        	threePanel.setBackground(Color.white);

            //volume panel
            JPanel volumePanel = addInformationLine("Volume: ", article.getVolume(), 230, 25);
            threePanel.add(volumePanel, gridBagConstraints);
            //number panel
            JPanel numberPanel = addInformationLine("Number: ", article.getNumber(), 230, 25);
            threePanel.add(numberPanel, gridBagConstraints);
            //journal panel
            JPanel journalPanel = addInformationLine("Journal: ", article.getJournal(), 240, 25);
            threePanel.add(journalPanel, gridBagConstraints);
            
            gridBagConstraints.gridy = 4;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.anchor = gridBagConstraints.WEST;
            gridBagConstraints.insets = new Insets(0, 0, 0, 0);
            detailedContainer.add(threePanel, gridBagConstraints);
        }
    
        //download button panel
        JPanel downloadButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        downloadButton.setBackground(blue);
        downloadButton.setPreferredSize(new Dimension(150,30));
        downloadButtonPanel.setBackground(Color.white);
        downloadButtonPanel.add(downloadButton);
        //download number panel
		JPanel downloadNumberPanel = new JPanel();
        JLabel titleLabel = new JLabel("Download number: ");
        downloadNum = new JLabel(selectedPaper.getDownloadNumber()+"");
        downloadNumberPanel.setLayout(new BoxLayout(downloadNumberPanel, BoxLayout.Y_AXIS));
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		downloadNum.setAlignmentX(Component.CENTER_ALIGNMENT);
		downloadNumberPanel.add(titleLabel);
		downloadNumberPanel.add(downloadNum);
        downloadButtonPanel.add(downloadNumberPanel);
              
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        detailedContainer.add(downloadButtonPanel, gridBagConstraints);

        //paperlist panel
		JPanel rlPanel = new JPanel();
		rlPanel.setBackground(Color.white);
		 //reading lists list
        rlList = new JList(researcher.getReadingLists().toArray());
        rlList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rlList.setLayoutOrientation(JList.VERTICAL);
        rlList.setVisibleRowCount(-1);
        JScrollPane rlListScroller = new JScrollPane(rlList);  
        rlListScroller.setPreferredSize(new Dimension(300, 60));
        gridBagConstraints.gridy = 0;
        rlPanel.add(rlListScroller, gridBagConstraints);
        
        //button
        JPanel buttonPanel =new JPanel();
        buttonPanel.setBackground(Color.white);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        addToRLButton.setBackground(blue);
        addToRLButton.setPreferredSize(new Dimension(200, 30));
        
        addToRLButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		removeFromRLButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		removeFromRLButton.setBackground(blue);
		removeFromRLButton.setPreferredSize(new Dimension(250, 30));
		buttonPanel.add(addToRLButton);
		buttonPanel.add(removeFromRLButton);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        rlPanel.add(buttonPanel, gridBagConstraints);
        
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        //gridBagConstraints.insets = new Insets(10, 0, 10, 0);
        detailedContainer.add(rlPanel, gridBagConstraints);
        
        
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(20, 0, 10, 0);
		add(detailedContainer, gridBagConstraints);
		SwingUtilities.updateComponentTreeUI(this);
		
	}
	
	public JPanel addInformationLine(String title, String text, int width, int heigth) {
        JPanel infoLinePanel = new JPanel();
        JLabel infoLineLabel = new JLabel(title);
    	JLabel infoLineText = new JLabel(text);
    	infoLineLabel.setFont(new Font("", Font.PLAIN, 14));
    	infoLineText.setFont(new Font("", Font.ITALIC, 12));
        infoLinePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        infoLinePanel.setPreferredSize(new Dimension(width,heigth));
        infoLinePanel.setBackground(Color.white);
        infoLinePanel.add(infoLineLabel);
        infoLinePanel.add(infoLineText);
        Border infoLineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        infoLinePanel.setBorder(infoLineBorder);
        return infoLinePanel;
	}
	
	public JPanel addDetailedRL(ReadingList readingList) {
		/*this.selectedReadingList = selectedReadingList;
		selectedReadingList.deleteObserver(this);
		detailedRLContainer.removeAll();
		selectedReadingList.addObserver(this);
		
		detailedRLContainer.setBackground(Color.white);
		detailedRLContainer.setPreferredSize(new Dimension(200,40));
		detailedRLContainer.setLayout(new GridBagLayout());
		
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        */
		return detailedRLContainer;		
	}
	
    public void downloadFile(ActionListener actionListener) {
        downloadButton.addActionListener(actionListener);
    }
    
    @Override
    public void update(java.util.Observable o, Object arg) {
		System.out.println("********inside update method paperspage");
		//selectedPaper.setListData(researcher.getFollowerResearchers().toArray());
		downloadNum.setText(this.selectedPaper.getDownloadNumber()+"");
    }
	
	public void selectPaper(ListSelectionListener listSelectionListener) {
		listContainer.getList().addListSelectionListener(listSelectionListener);
    }
	
	public void selectReadingList(ListSelectionListener listSelectionListener) {
		rlList.addListSelectionListener(listSelectionListener);
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

	public JList getRlList() {
		return rlList;
	}

	public void setRlList(JList rlList) {
		this.rlList = rlList;
	}



}
