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

    // tries to read matrix of m rows and n columns
    public static Matrix readMatrix(Scanner scanner, int m, int n) throws IllegalInputException {
        Matrix matrix = new Matrix(m, n);
        for (int i = 0; i < m; i++) {
            String row = null;
            if (scanner.hasNextLine()) {
                row = scanner.nextLine();
            } else throw new IllegalInputException();
            String[] columns = row.split(" ");
            if (columns.length != n) throw new IllegalInputException();
            for (int j = 0; j < n; j++) {
                matrix.set(i, j, columns[j]);
            }
        }
        return matrix;
    }

    public void addTo(int row, int col, String value) {
        matrix[row][col] += value;
    }

    // adds matrix of the same type by elements
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

    private String get(int row, int col) {
        return matrix[row][col];
    }

    public void set(int row, int col, String value) {
        matrix[row][col] = value;
    }

    // returns matrix in required string format
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        for (int row = 0; row < numOfRows; row++) {
            for (int col = 0; col < numOfColumns; col++) {
                result.append("[" + row + "," + col + "]: " + get(row, col) + "\n");
            }
        }
        return result.toString();
    }
}
