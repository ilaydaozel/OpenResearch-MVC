package interfaces;

import model.ReadingList;
import model.Researcher;

public interface IResearcher {
    String getUsername();
    void setUsername(String name);
    String getPassword();
    void setPassword(String password);
    void follow(Researcher researcher);
    void unfollow(Researcher researcher);
    void addNewReadingList(ReadingList newReadingList);
    void removeReadingList(ReadingList readingList);
    boolean addToReadingList(String readingListName, String paperName);
    boolean removeFromReadingList(String readingListName, String paperName);
}
