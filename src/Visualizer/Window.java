package Visualizer;

import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Window extends JFrame implements ComponentListener {
    Screen scr;

    public Window(int[][] matrix) {
        scr = new Screen(matrix);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addComponentListener(this);
        setSize(640, 480);
        add(scr);
    }

    public void componentResized(ComponentEvent e) {
        scr.WIDTH = getWidth() - 10;
        scr.HEIGHT = getHeight() - 30;
        scr.ResizeEvent();

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
