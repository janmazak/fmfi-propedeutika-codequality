import java.util.*;
import java.io.*;

public class ConcatenateMatrices {

    public static void main(String[] args) throws IOException {

        File inputFile = new File("vstup1.txt");
        if (!inputFile.exists()) {
            System.err.println("Input file does not exist");
            return;
        }

        Scanner scanner = new Scanner(inputFile);
        PrintStream output = new PrintStream("vystup.txt");

        String dimensionsLine = scanner.nextLine();
        String[] dimensions = dimensionsLine.split(" ");
        int numRows = Integer.parseInt(dimensions[0]);
        int numCols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[numRows][]; //matica a jej vynulovanie
        for (int k = 0; k < numRows; k++) {
            matrix[k] = new String[numCols];
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = "";
            }
        }
        while (scanner.hasNextLine()) { //cita pokial nenarazi na koniec (neexistujuci prvy riadok matice)
            for (int i = 0; i < numRows; i++) { //ak je dalsi riadok, tak urcite bude m-riadkov matice
                String riadok = scanner.nextLine(); //jeden riadok matice
                String[] prvky = riadok.split(" "); //rozdelenie riadku na prvky (stlpce)
                for (int j = 0; j < numCols; j++) { //prvky_length = n
                    matrix[i][j] += prvky[j]; //pricitanie do vyslednej matice
                }
            }
        }
        for (int i = 0; i < numRows; i++) { //formatovany vystup vyslednej matice
            for (int j = 0; j < numCols; j++) {
                output.printf("[%d,%d]: %s\n", i, j, matrix[i][j]);
            }
        }
        scanner.close();
    }
}
