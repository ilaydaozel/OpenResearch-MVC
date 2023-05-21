package model;

import java.util.Arrays;
import java.util.Observable;

import fileIO.JSONFileIO;
import interfaces.*;

public class ReadingList extends Observable{
	private int readingListId;
	private String readingListName;
	private Researcher creatorResearcher;	
	private int numOfPapers;
	private String[] nameOfPapers;
	
	
	public ReadingList(String name, Researcher researcher) {
		this.readingListName = name;
		this.creatorResearcher = researcher;
		updateJsonFile();
		
	}
	
	public void updateJsonFile() {
		IFileWriter createReadingListJSONFile = new JSONFileIO();
		System.out.println("JSON fıle updated with :  "+ this);
		createReadingListJSONFile.updateFile("readingList.json", this);
		setChanged();	
		notifyObservers();
	}
	
	public ReadingList(int readingListId,int numOfPapers,String[] nameOfPapers,String name, Researcher researcher) {
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
	public String[] getNameOfPapers() {
		return nameOfPapers;
	}
	public void setNameOfPapers(String[] nameOfPapers) {
		this.nameOfPapers = nameOfPapers;
		updateJsonFile();
		setChanged();	
		notifyObservers();
	}

	@Override
	public String toString() {
		return "Creator name: "+ creatorResearcher.getUsername() +"Reading list name: "+ getReadingListName();
	}
	

	
}
