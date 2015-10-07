package gui;

import algorithm.QuickSort;
import utility.MyArrayList;
import utility.MyNumber;
import utility.NumberReader;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class InputPanel extends JPanel implements ActionListener {

    private Board board;
    private NumberReader numberReader;
    private String fileName;

    private JButton algoBtn;
    private JButton lastBinAlgoBtn;
    private JButton stopBtn;
    private JButton resumeBtn;
    private JButton instantlyAlgoBtn;
    private JButton instantlyLastBinBtn;

    public InputPanel(NumberReader numberReader, Board board) {
        this.numberReader = numberReader;
        this.board = board;
        setBorder(BorderFactory.createEtchedBorder());
        addButtons();
        addInputField();
    }

    private void addButtons() {
        algoBtn = new JButton("Quicksort Algorithm");
        algoBtn.setEnabled(false);
        algoBtn.addActionListener(this);
        add(algoBtn);

        stopBtn = new JButton("Stop");
        stopBtn.setEnabled(false);
        stopBtn.addActionListener(this);
        add(stopBtn);

        resumeBtn = new JButton("Resume");
        resumeBtn.setEnabled(false);
        resumeBtn.addActionListener(this);
        add(resumeBtn);

        instantlyAlgoBtn = new JButton("Instantly draw Quicksort Algorithm");
        instantlyAlgoBtn.setEnabled(false);
        instantlyAlgoBtn.addActionListener(this);
        add(instantlyAlgoBtn);
    }

    private void addInputField() {
        JTextField fileNameField = new JFormattedTextField();
        fileNameField.getDocument().addDocumentListener(new DocumentListener() {
            void checkDocument(DocumentEvent e) {
                try {
                    fileName = e.getDocument().getText(0,
                            e.getDocument().getLength());
                    if (Pattern.matches("\\w+\\w*", fileName)) {
                        algoBtn.setEnabled(true);
                        instantlyAlgoBtn.setEnabled(true);
                    } else {
                        algoBtn.setEnabled(false);
                        instantlyAlgoBtn.setEnabled(false);
                    }
                } catch (BadLocationException ex) {
                    Logger.getLogger(InputPanel.class.getName()).
                            log(Level.SEVERE, null, ex);
                }

            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                checkDocument(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkDocument(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkDocument(e);
            }
        });
        fileNameField.setColumns(10);
        add(fileNameField);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        switch (button.getText()) {
            case "Quicksort Algorithm":
                runAlgorithm(false);
                board.drawAlgorithm();
                stopBtn.setEnabled(true);
                resumeBtn.setEnabled(false);
                break;
            case "Stop":
                resumeBtn.setEnabled(true);
                stopBtn.setEnabled(false);
                board.timer.stop();
                break;
            case "Resume":
                resumeBtn.setEnabled(false);
                stopBtn.setEnabled(true);
                board.timer.start();
                break;
            case "Instantly draw Quicksort Algorithm":
                runAlgorithm(true);
                board.drawAlgorithm();
                resumeBtn.setEnabled(false);
                stopBtn.setEnabled(false);
                break;
        }
    }


    private void runAlgorithm(boolean isInstantlyPaint) {
        QuickSort quickSort = new QuickSort();
        MyArrayList<MyNumber> myArrayList = numberReader.parseNumbers(fileName);

        for (Object object : quickSort.sort(myArrayList)) {
            MyNumber myNumber = (MyNumber) object;
            System.out.println(myNumber.getValue());
        }

        board.init(quickSort.getAllState(), isInstantlyPaint);
    }
}
