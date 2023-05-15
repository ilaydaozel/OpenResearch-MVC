package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import interfaces.IFileReader;
import interfaces.IFileWriter;
import java.io.File;

public class BibTeXFileIO implements IFileReader{
	
	
	@Override
    public Map<String, String> readFile(String filePath) {
        Map<String, String> articleData = new LinkedHashMap<>(); // Use LinkedHashMap to maintain the order

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),
                StandardCharsets.UTF_8))) {
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            String[] fieldNames = {
            		"author", "title","year", "volume", "number", "DOI", "journal","booktitle","doi" 
            };

            // Extract fields using regular expressions
            for (String field : fieldNames) {
                extractField(articleData, field, content.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return articleData;
    }

    private void extractField(Map<String, String> articleData, String field, String content) {
        
    	Pattern pattern = Pattern.compile(field + "\\s*=\\s*\\{([^}]*)}", Pattern.DOTALL);
        
        Matcher matcher = pattern.matcher(content);
        if(content.charAt(1)=='a') {
        	articleData.put("type", "article");
        }
        else {articleData.put("type", "conference paper");}
        if (matcher.find()) {
            String value = matcher.group(1);
            value= value.replaceAll("[{}'\\\\]", "");
            value = value.replace("\u2013", "-"); // Replace Unicode hyphen with ASCII hyphen
            
            articleData.put(field, value);
        }
    }
    
    public List<Map<String, String>> readAllFilesInSameDirectory(String directoryPath){
        File directory = new File(directoryPath);
        List<Map<String, String>> dataList = new ArrayList<>();
        
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
         
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".bib")) {
                    	
                    	
                        String filePath = file.getAbsolutePath();
                    	
                        Map<String, String> data = readFile(filePath);
                        
                        dataList.add(data);
                        
                       /* for (Map.Entry<String, String> entry : data.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }*/
                 
                    }
                }
            }
        }
        else {
        	System.out.println("directory not found");
        }
        return dataList;
    }
    
    public static void main(String[] args) {
    	List<Map<String, String>> dataList = new ArrayList<>();

        
    	IFileReader BibReader = new BibTeXFileIO();
    	dataList= BibReader.readAllFilesInSameDirectory("OpenResearch-MVC/src/data/");
    	IFileWriter csvWriter = new CsvFileIO();
    	csvWriter.writeAllPapers(dataList);

    }
}
    
