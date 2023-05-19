package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import interfaces.IFileReader;
import interfaces.IFileWriter;

public class PaperCollection {
    private List<Paper> papers;
    private IFileReader bibReader;
    private IFileWriter csvWriter;
    
    public PaperCollection() {
        papers = new ArrayList<>();
        createCollection();
    }
    
    public void createCollection() {
    	List<Map<String, String>> allPapers;

    	this.bibReader = new BibTeXFileIO();
    	allPapers = bibReader.readAllFilesInSameDirectory("OpenResearch-MVC/src/data/");

    	for (Map<String, String> data : allPapers) {
    		papers.add(createPaper(data));
        }   	
    }
    
    public Paper createPaper(Map<String, String> data) {
    	Random random = new Random();
    	if(data.get("type")=="article") {
			Paper article = new Article(
					data.getOrDefault("author", "no-authors"),
					data.getOrDefault("title", "no-title"),
					data.getOrDefault("year", "no-year"),
					data.getOrDefault("doi", "no-doi"),
					data.getOrDefault("volume", "no-volume"),
					data.getOrDefault("number", "no-number"),
					data.getOrDefault("journal","no-journal"),
					random.nextInt(1501));
			return article;
		}
		else {
			ConferencePaper conferencePaper = new ConferencePaper(
					data.getOrDefault("author", "no-authors"),
					data.getOrDefault("title", "no-title"),
					data.getOrDefault("year", "no-year"),
					data.getOrDefault("doi", "no-doi"),
					data.getOrDefault("booktitle", "no-booktitle"),
					random.nextInt(1501));
			return conferencePaper;
		}
    }
    


    public List<Paper> getPapers() {
        return papers;
    }
}
