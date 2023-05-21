package model;

import java.util.Observable;

public abstract class Paper extends Observable{
    private String authors;
    private String title;
    private String year;
    private String doi;
    private int downloadNumber;
    
    public Paper() {
    	this.authors = "";
        this.title = "";
        this.year = "";
        this.doi = "";
        this.downloadNumber = 0;
    }
    
    public Paper(String authors, String title, String year, String doi, int downloadNumber) {
        this.authors = authors;
        this.title = title;
        this.year = year;
        this.doi = doi;
        this.downloadNumber = downloadNumber;
    }

    public String getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }
    
    public String getDoi() {
        return doi;
    }

	public int getDownloadNumber() {
		return downloadNumber;
	}

	public void setDownloadNumber(int downloadNumber) {
		this.downloadNumber = downloadNumber;
		setChanged();	
		notifyObservers();
	}
}
