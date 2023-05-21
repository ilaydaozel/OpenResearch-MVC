package view;

import java.awt.Dimension;
import java.util.List;
import java.util.Observable;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class ListContainer extends JPanel {
    private List<Object> elementList;
    private JList<Object> list;

    public ListContainer(List<Object> elementList, int width, int height) {
        this.elementList = elementList;
        createList(width, height);
    }

    private void createList(int width, int height) {
        list = new JList<>(elementList.toArray());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(width, height));
        add(listScroller);
    }

    public JList<Object> getList() {
        return list;
    }

    public List<Object> getElementList() {
        return elementList;
    }

    public void setElementList(List<Object> elementList) {
        this.elementList = elementList;
    }
}
