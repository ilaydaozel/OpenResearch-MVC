package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BibTeXFile {
    public static Map<String, String> readArticleFile(String filePath) {
        Map<String, String> articleData = new LinkedHashMap<>(); // Use LinkedHashMap to maintain the order

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),
                StandardCharsets.UTF_8))) {
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            
            // Extracting fields using regular expressions
            extractField(articleData, "author", content.toString());
            extractField(articleData, "title", content.toString());
            extractField(articleData, "year", content.toString());
            extractField(articleData, "issue_date", content.toString());
            extractField(articleData, "publisher", content.toString());
            extractField(articleData, "address", content.toString());
            extractField(articleData, "volume", content.toString());
            extractField(articleData, "number", content.toString());
            extractField(articleData, "issn", content.toString());
            extractField(articleData, "abstract", content.toString());
            extractField(articleData, "journal", content.toString());
            extractField(articleData, "month", content.toString());
            extractField(articleData, "pages", content.toString());
            extractField(articleData, "numpages", content.toString());
            extractField(articleData, "keywords", content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return articleData;
    }

    private static void extractField(Map<String, String> articleData, String field, String content) {
        Pattern pattern = Pattern.compile(field + "\\s*=\\s*\\{([^}]*)}");
        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            String value = matcher.group(1);
            articleData.put(field, value);
        }
    }

    public static void main(String[] args) {
        String filePath = "article.txt";
        Map<String, String> data = readArticleFile(filePath);

        // Access the extracted information
        for (Map.Entry<String, String> entry : data.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
