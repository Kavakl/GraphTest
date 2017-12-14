import Logic.MatrixReader;
import Visualizer.Window;

public class Main {
    public static void main(String[] args) {
        MatrixReader m = new MatrixReader();
        new Window(m.mReader());
    }

}
