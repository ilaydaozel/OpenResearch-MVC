package fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import interfaces.IFileReader;
import interfaces.IFileWriter;
import model.Article;
import model.ConferencePaper;
import model.Paper;

import java.util.Random;
public class CsvFileIO implements IFileWriter{

	@Override
	public void write() {
		
	}
	@Override
	public void writeAllPapers(List<Object> allPapers) {
		try {
			FileWriter writer = new FileWriter("src/data/papers.csv");
		for (Object paper : allPapers) {
			paper = (Paper) paper;
			if (paper instanceof ConferencePaper) {
                ConferencePaper conferencePaper = (ConferencePaper) paper;
                writer.append("conference paper")
                .append(";")
                .append(conferencePaper.getAuthors())
                .append(";")
                .append(conferencePaper.getTitle())
                .append(";")
                .append(conferencePaper.getYear())
                .append(";")
                .append(conferencePaper.getDoi())
                .append(";")
                .append(conferencePaper.getBookTitle())
                .append(";")
                .append(String.valueOf(conferencePaper.getDownloadNumber()))
                .append("\n");
                
            } else if (paper instanceof Article) {
                Article article = (Article) paper;
                writer.append("article")
                .append(";")
                .append(article.getAuthors())
                .append(";")
                .append(article.getTitle())
                .append(";")
                .append(article.getYear())
                .append(";")
                .append(article.getVolume())
                .append(";")
                .append(article.getNumber())
                .append(";")
                .append(article.getDoi())
                .append(";")
                .append(article.getJournal())
                .append(";")
                .append(String.valueOf(article.getDownloadNumber()))
                .append("\n");
            }

        }
        // Flush and close the FileWriter object
        writer.flush();
        writer.close();
        // Print a message indicating that the file was created successfully
        System.out.println("papers.csv file generated successfully.");
		}catch (IOException e) {
            e.printStackTrace();
        }	
	}


}
