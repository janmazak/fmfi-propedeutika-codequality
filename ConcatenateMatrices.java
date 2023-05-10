import java.util.*;
import java.io.*;

public class ConcatenateMatrices {

    public static void main(String[] args) {
        String inputFilePath = "vstup.txt";
        String outputFilePath = "vystup.txt";

        try {
            String[][] concatenatedMatrix = readAndConcatenateMatrices(inputFilePath);
            writeMatrixToFile(concatenatedMatrix, outputFilePath);
        } catch (IOException e) {
            System.err.println("Problém so súborom: " + e.getMessage());
        }
    }

    private static String[][] readAndConcatenateMatrices(String filePath) throws IOException {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            scanner.nextLine();

            String[][] matrix = new String[m][n];

            while (scanner.hasNextLine()) {
                for (int i = 0; i < m; i++) {
                    String[] rowElements = scanner.nextLine().split(" ");
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = (matrix[i][j] == null) ? rowElements[j] : matrix[i][j] + rowElements[j];
                    }
                }
            }
            return matrix;
        }
    }

    private static void writeMatrixToFile(String[][] matrix, String filePath) throws IOException {
        try (PrintStream output = new PrintStream(filePath)) {
            int m = matrix.length;
            int n = matrix[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    output.printf("[%d,%d]: %s\n", i, j, matrix[i][j]);
                }
            }
        }
    }
}