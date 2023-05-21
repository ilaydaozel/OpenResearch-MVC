package interfaces;


import java.util.List;
import java.util.Map;

public interface ICollection {
    void createCollection();
    Object createCollectionElement(Map<String, String> data);
    List<Object> getCollection();
    void setCollection(List<Object> collection);
    void addToCollection(Object item);
    void removeFromItems(Object item);
}
