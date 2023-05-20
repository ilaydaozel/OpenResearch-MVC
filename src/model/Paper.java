package model;

// Paper.java
public abstract class Paper {
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

    // Getters and setters

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

	public int getDownloadNumber() {
		return downloadNumber;
	}

	public void setDownloadNumber(int downloadNumber) {
		this.downloadNumber = downloadNumber;
	}
}
