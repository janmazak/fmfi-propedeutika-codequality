import java.util.*;
import java.io.*;

public class ConcatenateMatrices {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new FileInputStream("vstup.txt")); // nacitanie vstupu
        PrintStream output = new PrintStream("vystup.txt"); // vystupny subor
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        String[][] matrix = new String[m][n]; // vyroba prazdnej matice
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = "";
            }
        }

        while (scanner.hasNext()) { // kym je cim, plni sa matica
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] += scanner.next();
                }
            }
        }

        for (int i = 0; i < m; i++) { //formatovany vystup vyslednej matice
            for (int j = 0; j < n; j++) {
                output.printf("[%d,%d]: %s\n", i, j, matrix[i][j]);
            }
        }
        output.close();
        scanner.close();
    }
}
