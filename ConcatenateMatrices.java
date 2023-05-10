import java.io.*;
import java.util.Scanner;

public class ConcatenateMatrices {
    public static void main(String[] args) throws IOException
    {
        // Declare variables for matrix size
        int rows, columns;

        // Open input file for reading
        Scanner in = new Scanner(new FileInputStream("vstup.txt"));
        // Open output file for writing
        PrintStream out = new PrintStream("vystup.txt");

        // If the input file is empty, close the files and return
        if(!in.hasNext()){
            out.close();
            in.close();
            return;
        }

        // Read matrix size from input file
        rows = in.nextInt();
        columns = in.nextInt();

        // Initialize 2D string array for storing matrix elements
        String[][] matrix = new String[rows][columns];
        // Initialize all elements to empty string
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                matrix[i][j] = "";
            }
        }

        // Read matrix elements from input file
        while (in.hasNext()) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    // Append the next element to the current element
                    matrix[i][j] = matrix[i][j].concat(in.next());
                }
            }
        }

        // Write the concatenated matrix to the output file
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++) {
                out.printf("[%d,%d]: %s\n", i, j, matrix[i][j]);
            }
        }

        // Close the input and output files
        out.close();
        in.close();
    }
}
