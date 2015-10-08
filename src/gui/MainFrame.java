package gui;

import utility.NumberReader;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    JPanel container;
    InputPanel inputPanel;
    JScrollPane pane;
    Board board;
    NumberReader numberReader;

    public MainFrame() {
        setTitle("Quicksort Algorithm");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 700);
        setLocationRelativeTo(null);

        container = new JPanel();
        container.setLayout(new BorderLayout());

        board = new Board();
        numberReader = new NumberReader();
        inputPanel = new InputPanel(numberReader, board);
        container.add(inputPanel, BorderLayout.SOUTH);

        pane = new JScrollPane(board);
        pane.setPreferredSize(new Dimension(1000, 0));
        container.add(pane, BorderLayout.CENTER);

        add(container);

        setVisible(true);
    }
}
