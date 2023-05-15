package model;

import java.util.Map;

public abstract class Paper {
    protected final String[] fieldNames = {
    		"author", "title", "year", "issue_date", "publisher", "address", "volume", "number",
            "issn", "abstract", "journal", "month", "pages", "numpages", "keywords","doi","series"
    };
    protected Map<String, String> content;
    
    // Constructors, getters, and setters
    
    public Paper() {
        
    }
    
    // Methods for accessing and modifying content
    
    public void setContent(String fieldName, String fieldValue) {
        content.put(fieldName, fieldValue);
    }
    
    public Map<String, String> getContent(String fieldName) {
        return content;
    }
    

}
