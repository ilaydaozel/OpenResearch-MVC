package model;

public class ReadingList {
	private int readingListId;
	private String creatorResearcherName;
	private String readingListName;
	private int numOfPapers;
	private String[] nameOfPapers;
	public int getReadingListId() {
		return readingListId;
	}
	public void setReadingListId(int readingListId) {
		this.readingListId = readingListId;
	}
	public String getCreatorResearcherName() {
		return creatorResearcherName;
	}
	public void setCreatorResearcherName(String creatorResearcherName) {
		this.creatorResearcherName = creatorResearcherName;
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
