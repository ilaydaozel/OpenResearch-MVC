package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PapersPage extends JPanel implements java.util.Observer {
    private JLabel label = new JLabel("Papers Page");
    private JButton viewButton = new JButton("View more");
    private JButton downloadButton = new JButton("Download File");
    private PaperListContainer listContainer = new PaperListContainer();
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private Color blue = new Color(144, 219, 244);

    public PapersPage() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());

        JPanel papersList = new JPanel();
        papersList.setLayout(new GridBagLayout());
        GridBagConstraints listGridBagConstraints = new GridBagConstraints();

        listGridBagConstraints.gridx = 0;
        listGridBagConstraints.gridy = 0;
        label.setFont(new Font("", Font.BOLD, 20));
        papersList.add(label, listGridBagConstraints);

        listGridBagConstraints.gridx = 0;
        listGridBagConstraints.gridy = 1;

        papersList.add(listContainer, listGridBagConstraints);

        listGridBagConstraints.gridx = 0;
        listGridBagConstraints.gridy = 2;
        viewButton.setBackground(blue);
        viewButton.setPreferredSize(new Dimension(150, 30));
        listGridBagConstraints.anchor = listGridBagConstraints.EAST;
        papersList.add(viewButton, listGridBagConstraints);

        listGridBagConstraints.gridx = 0;
        listGridBagConstraints.gridy = 3;
        downloadButton.setBackground(blue);
        downloadButton.setPreferredSize(new Dimension(150, 30));
        listGridBagConstraints.anchor = listGridBagConstraints.EAST;
        papersList.add(downloadButton, listGridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(papersList, gridBagConstraints);

    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        System.out.println("update/ mainpage");

    }

    public void selectPaper(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    public void downloadFile(ActionListener actionListener) {
        downloadButton.addActionListener(actionListener);
    }

    public JButton getViewButton() {
        return viewButton;
    }

    public void setViewButton(JButton viewButton) {
        this.viewButton = viewButton;
    }
}
