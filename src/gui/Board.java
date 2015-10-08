package gui;

import utility.MyArrayList;
import utility.MyNumber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Board extends JPanel implements ActionListener {

    Timer timer;
    final int size = 66;
    final int speed = 1000;
    final int pause = 1000;

    int rowNumber;
    int columnNumber;

    ArrayList<MyArrayList> allState;
    int stateNumber;
    boolean isInstantlyPaint;

    public Board() {
        setBorder(BorderFactory.createEtchedBorder());
        timer = new Timer(speed, this);
        timer.setInitialDelay(pause);
        isInstantlyPaint = false;
    }

    public void init(ArrayList<MyArrayList> allState, boolean isInstantlyPaint) {
        this.allState = allState;
        this.isInstantlyPaint = isInstantlyPaint;
        stateNumber = 0;
        columnNumber = allState.get(0).size();
        rowNumber = allState.size();
    }

    public void drawAlgorithm() {
        timer.start();
        drawBoard();
    }

    public void drawBoard() {
        setPreferredSize(new Dimension(
                columnNumber * (size + 10), (rowNumber) * (size + 10)));
        revalidate();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (allState != null && !allState.isEmpty()) {
            Graphics2D g2d = (Graphics2D) g.create();
            paintStates(g2d);
        }
    }

    private void paintStates(Graphics2D g2d) {
        int actBinY = 1;
        for (int i = 0; i < stateNumber; i++) {
            List<MyNumber> numbers = allState.get(i);
            if (i != 0 && !isSameRow(numbers, allState.get(i - 1))) {
                actBinY++;
            }
            for (int j = 0; j < numbers.size(); j++) {
                MyNumber actNumber = numbers.get(j);

                int actBinX = j + 1;


                fillNumber(g2d, actBinX, actBinY, actNumber);
                setColor(g2d, actNumber);
                paintNumber(g2d, actBinX, actBinY, actNumber.getValue());
            }
        }
    }

    private boolean isSameRow(List<MyNumber> currentNumbers, MyArrayList previousNumbers) {
        for (int i = 0; i < currentNumbers.size(); i++) {
            if (currentNumbers.get(i).getValue() != previousNumbers.get(i).getValue()) {
                return false;
            }

        }
        return true;
    }

    private void setColor(Graphics2D g2d, MyNumber actNumber) {
        if (actNumber.isJ() && actNumber.isI()) {
            g2d.setColor(new Color(0, 255, 255, 200));
        } else if (actNumber.isI()) {
            g2d.setColor(new Color(0, 0, 255, 200));
        } else if (actNumber.isJ()) {
            g2d.setColor(new Color(0, 255, 0, 200));
        } else {
            g2d.setColor(Color.black);
        }
    }

    private void paintNumber(Graphics2D g2d, int actBinX, int actBinY, int value) {
        g2d.setStroke(new BasicStroke(6));
        g2d.drawRect(actBinX * (size + 10) + 10,
                actBinY * (size + 10), size, size);

        drawNumberValue(g2d, actBinX, actBinY, value);
    }

    private void fillNumber(Graphics2D g2d, int actBinX, int actBinY, MyNumber actNumber) {
        if(actNumber.isPivot()){
            g2d.setColor(Color.red);
        }else{
            g2d.setColor(Color.white);
        }
        g2d.fillRect(actBinX * (size + 10) + 10,
                actBinY * (size + 10), size, size);

        drawNumberValue(g2d, actBinX, actBinY, actNumber.getValue());
    }

    private void drawNumberValue(Graphics2D g2d, int actBinX, int actBinY, int value) {
        g2d.setColor(Color.black);
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g2d.drawString(Integer.toString(value),
                actBinX * (size + 10) + 15,
                (actBinY) * (size + 10) + 40);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!isInstantlyPaint) {
            if (allState.size() - 1 > stateNumber) {
                drawBoard();
                stateNumber++;
            } else {
                timer.stop();
            }
            repaint();
        } else if (isInstantlyPaint) {
            while (allState.size() - 1 > stateNumber) {
                drawBoard();
                stateNumber++;
            }
            timer.stop();
            repaint();
        }
    }
}
