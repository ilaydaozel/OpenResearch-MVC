package model;

import java.util.List;
import java.util.Map;
import java.util.Observable;

import fileIO.CsvFileIO;

import java.util.ArrayList;

import interfaces.ICollection;
import interfaces.IFileReader;
import interfaces.IFileWriter;

public abstract class Collection extends Observable implements ICollection{
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
		setChanged();	
		notifyObservers();
    }

    
    public void addToCollection(Object item) {
    	collection.add(item);		
    	setChanged();	
		notifyObservers();
    	
    }

    public void removeFromItems(Object item) {
    	collection.remove(item);
		setChanged();	
		notifyObservers();
    }

	public IFileReader getReader() {
		return reader;
	}

	public void setReader(IFileReader reader) {
		this.reader = reader;
		setChanged();	
		notifyObservers();
	}

	public IFileWriter getWriter() {
		return writer;
	}

	public void setWriter(IFileWriter writer) {
		this.writer = writer;
		setChanged();	
		notifyObservers();
	}
    public void updateFile() {
        this.writer.writeAllPapers(this.collection);
		setChanged();	
		notifyObservers();
    }
   
}
