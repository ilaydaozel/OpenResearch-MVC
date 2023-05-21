package model;

import java.util.Map;

import fileIO.JSONFileIO;


public class ReadingListCollection extends Collection{
	
	public ReadingListCollection() {
		setReader(new JSONFileIO());
		setWriter(new JSONFileIO());
		createCollection();
	}
	@Override
	public void createCollection() {
		
		
	}

	@Override
	public Object createCollectionElement(Map<String, String> data) {
		// TODO Auto-generated method stub
		return null;
	}

}
