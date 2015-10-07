package gui;

import utility.NumberReader;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    JPanel container;
    Board board;
    InputPanel inputPanel;
    JScrollPane pane;

    public MainFrame(NumberReader numberReader) {
        setTitle("Quicksort Algorithm");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 700);
        setLocationRelativeTo(null);

        container = new JPanel();
        container.setLayout(new BorderLayout());

        board = new Board();
        inputPanel = new InputPanel(numberReader, board);
        container.add(inputPanel, BorderLayout.SOUTH);

        pane = new JScrollPane(board);
        pane.setPreferredSize(new Dimension(1000, 0));
        container.add(pane, BorderLayout.CENTER);

        add(container);

        setVisible(true);
    }
}
