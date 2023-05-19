package model;

//Article.java
public class Article extends Paper {
 private String volume;
 private String number;
 private String journal;

 public Article(String authors, String title, String year, String doi, String volume, String number, String journal,int downloadNumber) {
     super(authors, title, year, doi, downloadNumber);
     this.volume = volume;
     this.number = number;
     this.journal = journal;
 }

 // Getters and setters

 public String getVolume() {
     return volume;
 }

 public void setVolume(String volume) {
     this.volume = volume;
 }

 public String getNumber() {
     return number;
 }

 public void setNumber(String number) {
     this.number = number;
 }

 public String getJournal() {
     return journal;
 }

 public void setJournal(String journal) {
     this.journal = journal;
 }
 @Override
 public String toString() {
	 
	 return "A_" +getYear() +"_" +getTitle();
 }
}
