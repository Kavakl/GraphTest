package Logic;

import Visualizer.Window;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MatrixReader {
    public int[][] mReader(){
        int [][] matrix;
        int row;
        int coloumns;
        try(BufferedReader b = new BufferedReader(new FileReader("C:\\Users\\kaval\\IdeaProjects\\GraphTest\\matrix")))
        {
            String[] strSize = b.readLine().split("\\s+");
            row = Integer.parseInt(strSize[0]);
            coloumns = Integer.parseInt(strSize[1]);
            matrix = new int[row][coloumns];
            int lineCount = 0;
            String line;
            while ((line = b.readLine()) != null) {
                String[] numbers = line.split(" +");
                for ( int i = 0 ; i < numbers.length ; i++) {
                    matrix[lineCount][i] = Integer.parseInt(numbers[i]);
                }
                System.out.println();
                lineCount++;
            }
            return matrix;
        }catch (IOException e){
            e.getMessage();
        }
        return null;
    }
}
