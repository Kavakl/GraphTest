package Visualizer;

import Logic.MatrixCount;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MatrixViz {

    public int height, width;
    int[][] matrix;
    MatrixCount res;
    int CurrentRoute = 0;

    public MatrixViz(int[][] matrix) {
        this.matrix = matrix;
        height = matrix.length;
        width = matrix[0].length;
        res = new MatrixCount(matrix);
        res.launch();
    }

    public void nextRoute() {
        if (CurrentRoute < res.routesTmp.size() - 1)
            CurrentRoute++;
        else if (res.routesTmp.size() - 1 == -1)
            JOptionPane.showMessageDialog(null, CurrentRoute + " Routes");
        else {
            JOptionPane.showMessageDialog(null, CurrentRoute + 1 + " Routes");
            CurrentRoute = 0;
        }
    }

    public int[][] getMatr() {
        return matrix;
    }

    public ArrayList<Point> getRoute() {
        if (res.routesTmp.size() != 0)
            return res.routesTmp.get(CurrentRoute);
        return null;
    }
}
