package model;

// Paper.java
public abstract class Paper {
    private String[] authors;
    private String title;
    private int year;
    private String doi;

    public Paper(String[] authors, String title, int year, String doi) {
        this.authors = authors;
        this.title = title;
        this.year = year;
        this.doi = doi;
    }

    // Getters and setters

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }
}
