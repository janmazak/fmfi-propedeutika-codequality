import java.util.*;
import java.io.*;

public class ConcatenateMatrices {

    public static void main(String[] args) throws IOException {
        //checking if input file name was passed as argument
        //if not, use default name
        String inputFileName;
        if (args.length < 1){
            inputFileName = "vstup.txt";
        } else {
            inputFileName = args[0];
        }
        //checking if input file exists
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            System.err.println("Input file does not exist");
            return;
        }

        //reading input file
        Scanner scanner = new Scanner(inputFile);
        PrintStream output = new PrintStream("vystup.txt");

        //reading dimensions of matrix
        String dimensionsLine = scanner.nextLine();
        String[] dimensions = dimensionsLine.split(" ");
        int numRows = Integer.parseInt(dimensions[0]);
        int numCols = Integer.parseInt(dimensions[1]);

        //initialization of matrix
        String[][] matrix = new String[numRows][numCols];
        for (String[] row : matrix) {
            Arrays.fill(row, "");
        }
        //reading values from input file and concatenating them to matrix
        while (scanner.hasNextLine()) {
            for (int row = 0; row < numRows; row++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int col = 0; col < numCols; col++) {
                    matrix[row][col] += rowValues[col];
                }
            }
        }
        //printing matrix to output file
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                output.printf("[%d,%d]: %s\n", i, j, matrix[i][j]);
            }
        }

        output.close();
        scanner.close();
    }
}
