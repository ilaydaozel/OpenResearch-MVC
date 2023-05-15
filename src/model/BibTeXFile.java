package model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BibTeXFile {
    public static Map<String, String> readArticleFile(String filePath) {
        Map<String, String> articleData = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            // Extracting fields using regular expressions
            extractField(articleData, "title", content.toString());
            extractField(articleData, "author", content.toString());
            extractField(articleData, "year", content.toString());
            extractField(articleData, "abstract", content.toString());
            extractField(articleData, "journal", content.toString());
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
        String filePath = "src/data/A_2005_Introducing Test Automation and Test-Driven Development.bib";
        Map<String, String> data = readArticleFile(filePath);
        

		
        // Access the extracted information
        System.out.println(data.get("title"));
        System.out.println(data.get("author"));
        System.out.println(data.get("year"));
        System.out.println(data.get("abstract"));
        System.out.println(data.get("journal"));
        System.out.println(data.get("pages"));
        System.out.println(data.get("numpages"));
        System.out.println(data.get("keywords"));
    }
}
