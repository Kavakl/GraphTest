package Logic;
import static org.junit.Assert.*;

public class MatrixCountTest {
    @org.junit.Test
    public void countWayTest1() throws Exception {           //Проверка чтения из файла
        MatrixReader mr = new MatrixReader();                
        MatrixCount m = new MatrixCount(mr.mReader());
        m.launch();
        assertEquals(m.count,1);
    }
    @org.junit.Test
    public void countWayTest2() throws Exception {           //Проверка с отрицательными числами
        int [][] matrix = {
                {1,1,-1},
                {1,1,-10},
                {1,1,0}
        };
        MatrixCount m = new MatrixCount(matrix);
        m.launch();
        assertEquals(m.count,3);
    }
    @org.junit.Test
    public void countWayTest3() throws Exception {           //Проверка c начальным отрицательным шагом
        int [][] matrix = {
                {-1,1,1},
                {1,1,1},
                {1,1,0}
        };
        MatrixCount m = new MatrixCount(matrix);
        m.launch();
        assertEquals(m.count,0);
    }
    @org.junit.Test
    public void countWayTest4() throws Exception {           //Проверка с не еденичными шагами
        int [][] matrix = {
                {1,2,1,5},
                {3,1,1,2},
                {1,1,1,1},
                {1,4,5,2},
                {1,6,3,2},
                {3,2,3,0}
        };
        MatrixCount m = new MatrixCount(matrix);
        m.launch();
        assertEquals(m.count,4);
    }

}