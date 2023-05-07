import java.util.*;
import java.io.*;

public class StringMatrix {
    
    /**
     * Number of rows in the matrix.
     */
    private int m;

    /**
     * Number of columns in the matrix.
     */
    private int n;

    /**
     * Implementation of the matrix as 2D array.
     */
    private StringBuilder[][] matrix;

    /**
     * Constructs a matrix with empty strings.
     * @param rows Number of rows.
     * @param columns Number of columns.
     */
    public StringMatrix(int rows, int columns) {
        if (!(rows > 0 && columns > 0)) {
            throw new IllegalArgumentException("Attempting to create a matrix with non-positive dimensions.");
        }

        m = rows;
        n = columns;

        /* Creating a matrix, which elemenets are StringBuilder objects with empty strings. */
        matrix = new StringBuilder[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = new StringBuilder();
            }
        }        
    }

    /**
     * Prints the matrix by elements to given stream. Each element of the matrix will be printed in seperate
     * line together with its coordinates.
     * @param output Stream to which the matrix will be printed.
     */
    public void printMatrix(PrintStream output) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                output.printf("[%d,%d]: %s\n", i, j, matrix[i][j].toString());
            }
        }
    }

    /**
     * Reads string elements into matrix from given scanner. If flag @param replace is equal to true, the 
     * old matrix will be replaced by the new matrix entirely. Otherwise, new elements will be appended to
     * old elements (concatenation).
     * @param scanner Scanner from which elements are read into the matrix.
     * @param replace Flag indicating, whether the old elements should be replaced.
     */
    public void readMatrix(Scanner scanner, boolean replace) {
        try {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    String str = scanner.next();
                    if (replace) {
                        matrix[i][j].delete(0, matrix[i][j].length());
                    }
                    matrix[i][j].append(str);
                }
            }
        } catch (NoSuchElementException e) {
            System.err.println("Not enough elements while reading matrix.");
        }
    }
}
