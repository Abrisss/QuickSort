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
    ArrayList<MyArrayList> allState;
    int rowNumber;
    int columnNumber;
    boolean isInstantlyPaint;
    int stateNumber;

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
        for (int i = 0; i < stateNumber; i++) {
            List<MyNumber> numbers = allState.get(i);
            for (int j = 0; j < numbers.size(); j++) {
                MyNumber actNumber = numbers.get(j);

                setColor(g2d, actNumber);

                int actBinX = j + 1;
                int actBinY = i + 1;

                paintNumber(g2d, actBinX, actBinY, actNumber.getValue());
            }
        }
    }

    private void setColor(Graphics2D g2d, MyNumber actNumber) {
        if (actNumber.isI()) {
            g2d.setColor(Color.blue);
        } else if (actNumber.isJ()) {
            g2d.setColor(Color.green);
        } else if (actNumber.isPivot()) {
            g2d.setColor(Color.red);
        } else {
            g2d.setColor(Color.black);
        }
    }

    private void paintNumber(Graphics2D g2d, int actBinX, int actBinY, int value) {
        g2d.setStroke(new BasicStroke(6));
        g2d.drawRect(actBinX * (size + 10) + 10,
                actBinY * (size + 10), size, size);
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g2d.drawString(Integer.toString(value),
                actBinX * (size + 10) + 35,
                (actBinY) * (size + 10) + 35);
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
//            repaint();
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
