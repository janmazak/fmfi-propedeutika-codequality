import java.util.*;
import java.io.*;

public class ConcatenateMatrices {
    // Načíta dimenzie vstupných matíc zo súboru.
    private static int[] readMatrixDimensions(Scanner scanner) {
        String input = scanner.nextLine();
        String[] dimensions = input.split(" ");
        int m = Integer.parseInt(dimensions[0]);
        int n = Integer.parseInt(dimensions[1]);

        return new int[]{m, n};
    }

    // Načíta maticu typu 'm x n' zo súboru.
    private static String[][] readMatrix(Scanner scanner, int m, int n, String splitter) {
        String[][] matrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            String row = scanner.nextLine();
            String[] elements = row.split(splitter);
            for (int j = 0; j < n; j++) {
                matrix[i][j] = elements[j];
            }
        }
        return matrix;
    }

    // Zreťazí dve matice rovnakého typu prvok po prvku.
    private static String[][] concatenateMatrices(String[][] matrix1, String[][] matrix2) {
        int m = matrix1.length;
        int n = matrix1[0].length;
        String[][] result = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // Vypíše maticu do výstupného súboru v špecifikovanom formáte.
    private static void writeOutputMatrix(PrintStream output, String[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                output.printf("[%d,%d]: %s\n", i, j, matrix[i][j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Inicializuje vstupný a výstupný súbor.
        Scanner scanner = new Scanner(new File("vstup.txt")); // Vstupný súbor.
        PrintStream output = new PrintStream("vystup.txt"); // Výstupný súbor.

        // Načíta dimenzie vstupných matíc zo súboru.
        int[] dimensions = readMatrixDimensions(scanner);
        int m = dimensions[0];
        int n = dimensions[1];

        // Inicializuje zreťazenú maticu prázdnymi reťazcami.
        String[][] concatenatedMatrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(concatenatedMatrix[i], "");
        }

        // Načíta matice zo vstupného súboru a zreťazí ich.
        while (scanner.hasNextLine()) {
            String[][] matrix = readMatrix(scanner, m, n, " ");
            concatenatedMatrix = concatenateMatrices(concatenatedMatrix, matrix);
        }

        // Vypíše zreťazené matice do výstupného súboru.
        writeOutputMatrix(output, concatenatedMatrix, m, n);

        // Zavrie vstupný a výstupný súbor.
        scanner.close();
        output.close();
    }
}
