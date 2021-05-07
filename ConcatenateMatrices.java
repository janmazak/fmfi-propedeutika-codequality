import java.util.*;
import java.io.*;

public class ConcatenateMatrices {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("vstup.txt"));
        PrintStream output = new PrintStream("vystup.txt");
        String input = scanner.nextLine(); //prvy riadok (velmi pravdepodobne ide nakodit lahsie)
        String[] measurements = input.split(" ");
        int m = Integer.parseInt(measurements[0]);
        int n = Integer.parseInt(measurements[1]);

        String[][] matrix = new String[m][]; //matica a jej vynulovanie
        for (int k = 0; k < m; k++) {
            matrix[k] = new String[n];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = "";
            }
        }
        while (scanner.hasNextLine()) { //cita pokial nenarazi na koniec (neexistujuci prvy riadok matice)
            for (int i = 0; i < m; i++) { //ak je dalsi riadok, tak urcite bude m-riadkov matice
                String row = scanner.nextLine(); //jeden riadok matice
                String[] columns = row.split(" "); //rozdelenie riadku na prvky (stlpce)
                for (int j = 0; j < n; j++) { //prvky_length = n
                    matrix[i][j] += columns[j]; //pricitanie do vyslednej matice
                }
            }
        }
        for (int i = 0; i < m; i++) { //formatovany vystup vyslednej matice
            for (int j = 0; j < n; j++) {
                output.printf("[%d,%d]: %s\n", i, j, matrix[i][j]);
            }
        }
        scanner.close();
    }
}
