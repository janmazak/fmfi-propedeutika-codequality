import java.util.*;
import java.io.*;

public class ConcatenateMatrices {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("vstup.txt"));
        PrintStream output = new PrintStream("vystup.txt");
        String vstup = scanner.nextLine(); //prvy riadok (velmi pravdepodobne ide nakodit lahsie)
        String[] rozmery = vstup.split(" ");
        int m = Integer.parseInt(rozmery[0]);
        int n = Integer.parseInt(rozmery[1]);

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
                String riadok = scanner.nextLine(); //jeden riadok matice
                String[] prvky = riadok.split(" "); //rozdelenie riadku na prvky (stlpce)
                for (int j = 0; j < n; j++) { //prvky_length = n
                    matrix[i][j] += prvky[j]; //pricitanie do vyslednej matice
                }
            }
        }
        for (int i = 0; i < m; i++) { //formatovany vystup vyslednej matice
            for (int j = 0; j < n; j++) {
                output.printf("[%d,%d]: %s\n", i, j, matrix[i][j]);
            }
        }
        scanner.close();
        output.close();
    }
}
