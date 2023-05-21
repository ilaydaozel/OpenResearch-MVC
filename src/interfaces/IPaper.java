package interfaces;


public interface IPaper {
    String getAuthors();
    String getTitle();
    String getYear();
    String getDoi();
    int getDownloadNumber();
    void setDownloadNumber(int downloadNumber);
}
