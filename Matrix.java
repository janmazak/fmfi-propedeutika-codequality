import java.util.*;
import java.io.*;

public class Matrix {
    private String[][] matrix;

    public Matrix(int m, int n) {
        matrix = new String[m][n];
        for (String[] line : matrix) {
            Arrays.fill(line, "");
        }
    }

    // try to read matrix of m rows and n columns, not used, not tested yet, TODO: custom exceptions
    public void readMatrix(Scanner scanner, int m, int n) {
        for (int i = 0; i < m; i++) {
            String row = null;
            if (scanner.hasNextLine()) {
                row = scanner.nextLine();
            }else throw new NoSuchElementException();
            String[] columns = row.split(" ");
            if(columns.length != n) throw new NoSuchElementException();
            for(int j =0; j < m; j++){
                matrix[i][j] = columns[j];
            }
        }
    }

    public void addTo(int row, int col, String value){
        matrix[row][col] += value;
    }

    public String get(int row, int col){
        return matrix[row][col];
    }
}
