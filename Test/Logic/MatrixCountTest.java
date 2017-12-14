package Logic;

import static org.junit.Assert.*;

public class MatrixCountTest {
    @org.junit.Test
    public void countWay() throws Exception {
        int matrix[][] = {{2,1,1},{1,1,1},{1,1,1}};
        MatrixCount m = new MatrixCount(matrix);
        m.launch();
        assertEquals(m.count,2);
    }

}