package Logic;

import java.awt.*;
import java.util.ArrayList;

public class MatrixCount {
    public int count = 0;
    int[][] arr;

    public ArrayList<ArrayList<Point>> routesTmp = new ArrayList<>();

    public MatrixCount(int[][] arr) {
        this.arr = arr;
    }

    public void launch() {
        countWay(0, 0, new ArrayList<>());
    }

    public void countWay(int i, int j, ArrayList<Point> routes) {
        ArrayList<Point> routes1 = new ArrayList<>(routes);
        routes1.add(new Point(i, j));
        if (j < arr[i].length - 1 || i < arr.length - 1) {
            if (i + arr[i][j] < arr.length && arr[i][j] > 0) {
                countWay(i + arr[i][j], j, routes1);
            }
            if (j + arr[i][j] < arr[i].length && arr[i][j] > 0) {
                countWay(i, j + arr[i][j], routes1);
            }
        } else if (i == arr.length - 1 && j == arr[i].length - 1) {
            routesTmp.add(routes1);
            count++;
        }
    }
}
