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
     * Implementation of the matrix as 2D array list.
     */
    private ArrayList<ArrayList<StringBuilder>> matrix;

    /**
     * Constructs a matrix with empty strings.
     * @param rows Number of rows.
     * @param columns Number of columns.
     */
    public StringMatrix(int rows, int columns) {
        m = rows;
        n = columns;

        /* Creating a matrix, which elemenets are StringBuilder objects with empty strings. */
        matrix = new ArrayList<>(rows);
        for (int i = 1; i <= rows; i++) {
            ArrayList<StringBuilder> row = new ArrayList<>(columns);
            for (int j = 1; j <= columns; j++) {
                row.add(new StringBuilder(""));
            }
            matrix.add(row);
        }        
    }
}
