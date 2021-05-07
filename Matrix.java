import java.util.*;
import java.io.*;

public class Matrix {
    private String[][] matrix;
    private int numOfRows;
    private int numOfColumns;

    public Matrix(int m, int n) {
        numOfRows = m;
        numOfColumns = n;
        matrix = new String[m][n];
        for (String[] line : matrix) {
            Arrays.fill(line, "");
        }
    }

    // try to read matrix of m rows and n columns TODO: custom exceptions
    public static Matrix readMatrix(Scanner scanner, int m, int n) {
        Matrix matrix = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            String row = null;
            if (scanner.hasNextLine()) {
                row = scanner.nextLine();
            } else throw new NoSuchElementException();
            String[] columns = row.split(" ");
            if (columns.length != n) throw new NoSuchElementException();
            for (int j = 0; j < n; j++) {
                matrix.set(i, j, columns[j]);
            }
        }
        return matrix;
    }

    public void addTo(int row, int col, String value) {
        matrix[row][col] += value;
    }

    public void addMatrix(Matrix matrix) {
        if (numOfRows != matrix.numOfRows || numOfColumns != matrix.numOfColumns) {
            throw new IllegalArgumentException();
        }
        for (int row = 0; row < numOfRows; row++) {
            for (int col = 0; col < numOfColumns; col++) {
                this.addTo(row, col, matrix.get(row, col));
            }
        }
    }

    public String get(int row, int col) {
        return matrix[row][col];
    }

    public void set(int row, int col, String value) {
        matrix[row][col] = value;
    }

    @Override
    public String toString() {
        String result = "";
        for (String[] row : matrix) {
            for (String col : row) {
                result += col;
                result += " ";
            }
            result += "\n";
        }
        return result;
    }
}
