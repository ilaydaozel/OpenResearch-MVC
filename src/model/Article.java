package model;

//Article.java
public class Article extends Paper {
 private int volume;
 private int number;
 private String journal;

 public Article(String[] authors, String title, int year, String doi, int volume, int number, String journal) {
     super(authors, title, year, doi);
     this.volume = volume;
     this.number = number;
     this.journal = journal;
 }

 // Getters and setters

 public int getVolume() {
     return volume;
 }

 public void setVolume(int volume) {
     this.volume = volume;
 }

 public int getNumber() {
     return number;
 }

 public void setNumber(int number) {
     this.number = number;
 }

 public String getJournal() {
     return journal;
 }

 public void setJournal(String journal) {
     this.journal = journal;
 }
}
