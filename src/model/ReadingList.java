package model;

public class ReadingList {
	private int readingListId;
	private String readingListName;
	private Researcher creatorResearcher;	
	private int numOfPapers;
	private String[] nameOfPapers;
	
	public ReadingList(String name, Researcher researcher) {
		this.readingListName = name;
		this.creatorResearcher = researcher;
	}
	public int getReadingListId() {
		return readingListId;
	}
	public void setReadingListId(int readingListId) {
		this.readingListId = readingListId;
	}
	public Researcher getCreatorResearcher() {
		return creatorResearcher;
	}
	public void setCreatorResearcherName(Researcher creatorResearcher) {
		this.creatorResearcher = creatorResearcher;
	}
	public String getReadingListName() {
		return readingListName;
	}
	public void setReadingListName(String readingListName) {
		this.readingListName = readingListName;
	}
	public int getNumOfPapers() {
		return numOfPapers;
	}
	public void setNumOfPapers(int numOfPapers) {
		this.numOfPapers = numOfPapers;
	}
	public String[] getNameOfPapers() {
		return nameOfPapers;
	}
	public void setNameOfPapers(String[] nameOfPapers) {
		this.nameOfPapers = nameOfPapers;
	}
}
