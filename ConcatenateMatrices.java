import java.util.*;
import java.io.*;

public class ConcatenateMatrices {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadajte názov vstupného súboru:");
        String inputFileName = scanner.nextLine();
        System.out.println("Zadajte názov výstupného súboru:");
        String outputFileName = scanner.nextLine();
        Scanner input = new Scanner(new File(inputFileName));


        int m = input.nextInt(), n = input.nextInt();
        input.nextLine();

        Matrix matrix = new Matrix(m, n);

        // TODO what to do with exceptions
        while (input.hasNext()) {
            Matrix nextMatrix = null;
            // reading next matrix from input file
            try {
                nextMatrix = Matrix.readMatrix(input, m, n);
            } catch (NoSuchElementException e) {
                System.out.println("Nesprávne zadaná matica");
                break;
            }

            // adding successfully read matrix to the result matrix
            try {
                matrix.addMatrix(nextMatrix);
            } catch (IllegalArgumentException e) {
                System.out.println("Matice nie sú rovnakého typu");
                break;
            }
        }

        PrintStream output = new PrintStream(outputFileName);
        for (int i = 0; i < m; i++) { //formatovany vystup vyslednej matice
            for (int j = 0; j < n; j++) {
                output.printf("[%d,%d]: %s\n", i, j, matrix.get(i, j));
            }
        }
        input.close();
        output.close();
    }
}
