package model;

import java.util.List;
import java.util.Map;
import java.util.Observable;

import fileIO.CsvFileIO;

import java.util.ArrayList;
import interfaces.IFileReader;
import interfaces.IFileWriter;

public abstract class Collection extends Observable {
    private List<Object> collection = new ArrayList<>();
    private IFileReader reader;
    private IFileWriter writer;
    public Collection() {
        
        
    }

    public abstract void createCollection();

    public abstract Object createCollectionElement(Map<String, String> data);

    public List<Object> getCollection() {
        return collection;
    }

    public void setCollection(List<Object> collection) {
        this.collection = collection;
    }

    
    public void addToCollection(Object item) {
    	collection.add(item);
    }

    public void removeFromItems(Object item) {
    	collection.remove(item);
    }

	public IFileReader getReader() {
		return reader;
	}

	public void setReader(IFileReader reader) {
		this.reader = reader;
	}

	public IFileWriter getWriter() {
		return writer;
	}

	public void setWriter(IFileWriter writer) {
		this.writer = writer;
	}
    public void updateFile() {
        this.writer.writeAllPapers(this.collection);
    }
   
}
