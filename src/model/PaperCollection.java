package model;

import java.util.List;
import java.util.Map;
import java.util.Random;

import fileIO.BibTeXFileIO;
import fileIO.CsvFileIO;
import interfaces.IFileWriter;

public class PaperCollection extends Collection{
    private IFileWriter csvWriter = new CsvFileIO();
    
    public PaperCollection() {
		setReader(new BibTeXFileIO());
		createCollection();
        csvWriter.writeAllPapers(getCollection());
    }
    
    public void createCollection() {
    	List<Map<String, String>> allPapers;
    	allPapers = getReader().readAllElements("src/data/");

    	for (Map<String, String> data : allPapers) {
    		addToCollection(createCollectionElement(data));
        }   	
    }
    
    public Object createCollectionElement(Map<String, String> data) {
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
    public void updateCsvFile() {
        csvWriter.writeAllPapers(getCollection());
    }
   

}
