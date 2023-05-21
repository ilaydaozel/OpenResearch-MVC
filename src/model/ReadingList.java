package model;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Observable;

import fileIO.JSONFileIO;
import interfaces.*;

public class ReadingList extends Observable{
	private int readingListId;
	private String readingListName;
	private Researcher creatorResearcher;	
	private int numOfPapers;
	private List<String> nameOfPapers;
	
	
	public ReadingList(String name, Researcher researcher) {
		this.readingListName = name;
		this.creatorResearcher = researcher;
		this.numOfPapers = 0;
		this.nameOfPapers = new ArrayList<>();
		updateJsonFile();
		
	}
	
	public void updateJsonFile() {
		IFileWriter createReadingListJSONFile = new JSONFileIO();
		System.out.println("JSON fıle updated with :  "+ this);
		createReadingListJSONFile.updateFile("readingList.json", this);
		setChanged();	
		notifyObservers();
	}
	
	public ReadingList(int readingListId,int numOfPapers,List<String> nameOfPapers,String name, Researcher researcher) {
		this.readingListId = readingListId;
		this.numOfPapers = numOfPapers;
		this.nameOfPapers = nameOfPapers;
		this.readingListName = name;
		this.creatorResearcher = researcher;	
	}
	public int getReadingListId() {
		return readingListId;
	}
	public void setReadingListId(int readingListId) {
		this.readingListId = readingListId;
		updateJsonFile();
		setChanged();	
		notifyObservers();
	}
	public Researcher getCreatorResearcher() {
		return creatorResearcher;
	}
	public void setCreatorResearcherName(Researcher creatorResearcher) {
		this.creatorResearcher = creatorResearcher;
		updateJsonFile();
		setChanged();	
		notifyObservers();
	}
	public String getReadingListName() {
		return readingListName;
	}
	public void setReadingListName(String readingListName) {
		this.readingListName = readingListName;
		updateJsonFile();
		setChanged();	
		notifyObservers();
	}
	public int getNumOfPapers() {
		return numOfPapers;
	}
	public void setNumOfPapers(int numOfPapers) {
		
		this.numOfPapers = numOfPapers;
		updateJsonFile();
		setChanged();	
		notifyObservers();
	}
	public List<String> getNameOfPapers() {
		return nameOfPapers;
	}
	public void setNameOfPapers(List<String> nameOfPapers) {
		this.nameOfPapers = nameOfPapers;
		updateJsonFile();
		setChanged();	
		notifyObservers();
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    if (nameOfPapers != null && !nameOfPapers.isEmpty()) {
	        for (int i = 0; i < nameOfPapers.size(); i++) {
	            sb.append(nameOfPapers.get(i));
	            if (i < nameOfPapers.size() - 1) {
	                sb.append("; ");
	            }
	        }
	    }

	    String result = sb.toString();

	    return getReadingListName() + ": " + result;
	}
	

	
}
