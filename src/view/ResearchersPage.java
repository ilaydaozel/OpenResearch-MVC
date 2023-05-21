
package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionListener;

import model.Article;
import model.Collection;
import model.Paper;
import model.Researcher;
import model.ResearcherCollection;


public class ResearchersPage extends JPanel implements java.util.Observer{
	private Collection researcherCollection;
    private List<Object> researcherList;
    private ListContainer listContainer; 
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private JPanel detailedContainer = new JPanel();
	private JLabel usernameLabel = new JLabel("User:");
	private JLabel username = new JLabel();
	private JButton followButton = new JButton("Follow");
	private JButton unfollowButton = new JButton("Unfollow");
    private Color blue = new Color(144, 219, 244);
    private JList rlList;
    private Researcher selectedResearcher = new Researcher();

    
    public ResearchersPage(Collection researcherCollection) {
    	this.researcherCollection = researcherCollection;
    	this.researcherList = researcherCollection.getCollection();
		this.listContainer = new ListContainer(researcherList, 500, 100);
    	researcherCollection.addObserver(this);
    	initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
    	JLabel pageLabel = new JLabel("RESEARCHERS");
    	pageLabel.setFont(new Font("", Font.BOLD, 20));
    	pageLabel.setForeground(blue);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(pageLabel,gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(listContainer, gridBagConstraints);    
        addDetailedContainer(selectedResearcher);
    }

	public void addDetailedContainer(Researcher selectedResearcher) {
		this.selectedResearcher = selectedResearcher;

		detailedContainer.removeAll();
    	selectedResearcher.addObserver(this);

		detailedContainer.setBackground(Color.white);
		detailedContainer.setPreferredSize(new Dimension(800,300));
		detailedContainer.setLayout(new GridBagLayout());
        Border detailedContainerBorder = BorderFactory.createLineBorder(blue, 1);
        detailedContainer.setBorder(detailedContainerBorder);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        //create upPanel
        JPanel upPanel = new JPanel();
        upPanel.setBackground(Color.white);
        
        //create nameInfo panel
        JPanel nameInfoPanel = new JPanel();
        nameInfoPanel.setPreferredSize(new Dimension(200,30));
        usernameLabel.setFont(new Font("", Font.BOLD, 18));
        usernameLabel.setForeground(blue);
        username.setFont(new Font("", Font.PLAIN, 16));
    	username.setVerticalAlignment(SwingConstants.CENTER);
        nameInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        nameInfoPanel.setBackground(Color.white);
        nameInfoPanel.add(usernameLabel);
        nameInfoPanel.add(new JLabel(selectedResearcher.getUsername()));
        username.setAlignmentY(BOTTOM_ALIGNMENT);
        usernameLabel.setAlignmentY(BOTTOM_ALIGNMENT);;
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        nameInfoPanel.setBorder(border);
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        upPanel.add(nameInfoPanel, gridBagConstraints);
        
        //buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(350, 40));
        buttonPanel.setBackground(Color.white);
        //follow button
        followButton.setBackground(blue);
        followButton.setPreferredSize(new Dimension(150,30));
        buttonPanel.add(followButton);
        //unfollow button
        unfollowButton.setBackground(blue);
        unfollowButton.setPreferredSize(new Dimension(150,30));
        buttonPanel.add(unfollowButton);
        //add button panel to upPanel
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = gridBagConstraints.WEST;
        upPanel.add(buttonPanel, gridBagConstraints); 
        //ad upPanel to detailedContainer
        gridBagConstraints.gridy = 0;
        detailedContainer.add(upPanel, gridBagConstraints);
 
        //reading list list label
        JPanel readingListPanel = new JPanel(new GridBagLayout());
        readingListPanel.setBackground(Color.white);
        GridBagConstraints rlGridBagConstraints = new GridBagConstraints();
        rlGridBagConstraints.gridy = 1;
    	JLabel rlLabel = new JLabel("Reading lists of " + selectedResearcher.getUsername());
    	rlLabel.setFont(new Font("", Font.BOLD, 14));
    	rlLabel.setForeground(blue);
    	rlGridBagConstraints.anchor = GridBagConstraints.WEST;
        readingListPanel.add(rlLabel, rlGridBagConstraints);
        
        //reading lists list
        rlList = new JList(selectedResearcher.getReadingLists().toArray());
        rlList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rlList.setLayoutOrientation(JList.VERTICAL);
        rlList.setVisibleRowCount(-1);
        JScrollPane rlListScroller = new JScrollPane(rlList);  
        rlListScroller.setPreferredSize(new Dimension(600,70));
        rlGridBagConstraints.gridy = 2;
        rlGridBagConstraints.insets = new Insets(10, 0, 10, 0);
        readingListPanel.add(rlListScroller, rlGridBagConstraints);
        gridBagConstraints.gridy = 1;
        detailedContainer.add(readingListPanel, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(20, 0, 10, 0);
		add(detailedContainer, gridBagConstraints);
		SwingUtilities.updateComponentTreeUI(this);
		
	}
	
    public void followResearcher(ActionListener actionListener) {
    	followButton.addActionListener(actionListener);

    }
    
    public void unfollowResearcher(ActionListener actionListener) {
    	unfollowButton.addActionListener(actionListener);
    }
    
    
	@Override
	public void update(Observable o, Object arg) {
		
		rlList.setListData(selectedResearcher.getReadingLists().toArray());
		// TODO Auto-generated method stub
	}
	
	public void selectResearcher(ListSelectionListener listSelectionListener) {
		listContainer.getList().addListSelectionListener(listSelectionListener);
    }

	public ListContainer getListContainer() {
		return listContainer;
	}

	public void setListContainer(ListContainer listContainer) {
		this.listContainer = listContainer;
	}


}
