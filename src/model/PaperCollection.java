package model;

import java.util.ArrayList;
import java.util.List;

public class PaperCollection {
    private List<Paper> papers;

    public PaperCollection() {
        papers = new ArrayList<>();
    }

    public void addPaper(Paper paper) {
        papers.add(paper);
    }

    public void removePaper(Paper paper) {
        papers.remove(paper);
    }

    public List<Paper> getPapers() {
        return papers;
    }
}
