package gui;

import utility.MyArrayList;
import utility.MyNumber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class Board extends JPanel implements ActionListener {

    Timer timer;
    final int size = 77;
    final int speed = 1000;
    final int pause = 1000;
    MyArrayList<MyArrayList<MyNumber>> allState;
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

    public void init(MyArrayList<MyArrayList<MyNumber>> allState, boolean isInstantlyPaint) {
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
        List<MyNumber> numbers = allState.get(stateNumber);
        for (int i = 0; i < numbers.size(); i++) {
            MyNumber actNumber = numbers.get(i);

            setColor(g2d, actNumber);

            int actBinX = i + 1;
            int actBinY = stateNumber + 1;

            paintNumber(g2d, actBinX, actBinY);
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

    private void paintNumber(Graphics2D g2d, int actBinX, int actBinY) {
        g2d.setStroke(new BasicStroke(6));
        g2d.drawRect(actBinX * (size + 10) + 10,
                actBinY * (size + 10), size, size);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!isInstantlyPaint) {
            if (allState.size() < stateNumber) {
                drawBoard();
                stateNumber++;
            } else {
                timer.stop();
            }
            repaint();
        } else if (isInstantlyPaint) {
            while (allState.size() < stateNumber) {
                drawBoard();
                stateNumber++;
            }
            timer.stop();
            repaint();
        }
    }
}
