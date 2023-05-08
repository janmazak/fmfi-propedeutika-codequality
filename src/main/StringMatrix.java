package main;

import java.util.*;
import java.io.*;

/**
 * Class representing a modifiable matrix, which elements are strings.
 */
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
     * Constructs a matrix with given dimensions and with empty strings as elements.
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
     * Reads string elements into the matrix from given Scanner. If flag @param replace is equal to true, the 
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
        }
        catch (NoSuchElementException e) {
            System.err.println("Error with reading elements into the matrix.");
            throw new IllegalArgumentException("Not enough elements to be read from the input.");
        }
    }

    /**
     * Returns element as String at given position in the matrix.
     * @param row Row of the matrix (numbered from 0).
     * @param column Column of the matrix (numbered from 0).
     * @return String representation of element in the matrix at given position.
     */
    public String getElement(int row, int column) {
        if (!(row >= 0 && column >= 0 && row < m && column < n)) {
            throw new IllegalArgumentException("Position is out of range.");
        }
        return matrix[row][column].toString();
    }

    /**
     * Prints the matrix by elements to given stream. Each element of the matrix will be printed in seperate
     * line together with its coordinates.
     * @param stream Stream to which the matrix will be printed.
     */
    public void printMatrixElements(PrintStream stream) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                stream.printf("[%d,%d]: %s\n", i, j, matrix[i][j].toString());
            }
        }
    }

    /**
     * Prints the matrix in a grid.
     * @param stream Stream to which the matrix will be printed.
     */
    public void printMatrix(PrintStream stream) {
        stream.println(Arrays.deepToString(matrix).replace("], ", "\n").replaceAll("[,\\[\\]]",""));
    }
}
