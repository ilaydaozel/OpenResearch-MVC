package model;

import java.util.Map;

public class ConferencePaper extends Paper {
	private final String[] fieldNames ={
            "author", "title", "year", "doi","booktitle" 
    };
	
	private  Map<String, String> content ;
}
