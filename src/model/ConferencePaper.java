package model;


//ConferencePaper.java
public class ConferencePaper extends Paper {
 private String bookTitle;

 public ConferencePaper(String authors, String title, String year, String doi, String bookTitle,int downloadNumber) {
     super(authors, title, year, doi, downloadNumber);
     this.bookTitle = bookTitle;
 }

 // Getter and setter

 public String getBookTitle() {
     return bookTitle;
 }

 public void setBookTitle(String bookTitle) {
     this.bookTitle = bookTitle;
 }
 @Override
 public String toString() {
	 
	 return "IP_" +getYear() +"_" +getTitle();
 }
}
