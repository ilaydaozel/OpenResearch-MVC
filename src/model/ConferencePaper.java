package model;


//ConferencePaper.java
public class ConferencePaper extends Paper {
 private String bookTitle;

 public ConferencePaper(String[] authors, String title, int year, String doi, String bookTitle) {
     super(authors, title, year, doi);
     this.bookTitle = bookTitle;
 }

 // Getter and setter

 public String getBookTitle() {
     return bookTitle;
 }

 public void setBookTitle(String bookTitle) {
     this.bookTitle = bookTitle;
 }
}
