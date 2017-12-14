package Visualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Screen extends JPanel implements ActionListener {

    MatrixViz viz;
    Dimension Cell;
    Font ValueFont;

    public int HEIGHT = 480, WIDTH = 640, OTSTUP = 5;

    Timer myTimer = new Timer(2000, this);

    public Screen(int[][] matrix) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        viz = new MatrixViz(matrix);
        CalcSizes();
        myTimer.start();
    }

    private void CalcSizes() {
        int height, width;
        width = (WIDTH - (viz.width - 1) * OTSTUP) / viz.width;
        height = (HEIGHT - (viz.height - 1) * OTSTUP) / viz.height;
        Cell = new Dimension(width, height);
        ValueFont = new Font("Dialog", Font.PLAIN, Math.min(width, height));
    }

    private void DrawMatrix(Graphics g) {
        g.setColor(Color.BLACK);
        int[][] matr = viz.getMatr();
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                g.fillRect(j * (Cell.width + OTSTUP), i * (Cell.height + OTSTUP), Cell.width, Cell.height);
            }
        }
    }

    private void DrawRoute(Graphics g) {
        g.setColor(Color.GRAY);
        if (viz.getRoute() != null) {
            ArrayList<Point> route = viz.getRoute();
            for (Point i : route) {
                g.fillOval(i.y * (Cell.width + OTSTUP), i.x * (Cell.height + OTSTUP), Cell.width, Cell.height);
            }
        }
    }

    private void PlaceValues(Graphics g) {
        g.setFont(ValueFont);
        g.setColor(Color.RED);
        int[][] matr = viz.getMatr();
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                String resStr = String.format("%d", matr[i][j]);
                g.drawString(resStr, j * (Cell.width + OTSTUP) + Cell.width / 2 - (ValueFont.getSize() * resStr.length()) / 3, i * (Cell.height + OTSTUP) + Cell.height / 3 + ValueFont.getSize() / 2);
            }
        }
    }


    @Override
    public void paint(Graphics g) {
        DrawMatrix(g);
        DrawRoute(g);
        PlaceValues(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        viz.nextRoute();
        repaint();
    }

    public void ResizeEvent() {
        CalcSizes();
    }
}
