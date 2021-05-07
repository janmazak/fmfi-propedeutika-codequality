import java.util.*;
import java.io.*;

public class ConcatenateMatrices {

    private static String[][] makeResultMatrix(int m, int n){
        String[][] resultMatrix = new String[m][n];
        for (String[] strings : resultMatrix) {
            Arrays.fill(strings, "");
        }
        return resultMatrix;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadajte názov vstupného súboru:");
        String inputFileName = scanner.nextLine();
        System.out.println("Zadajte názov výstupného súboru:");
        String outputFileName = scanner.nextLine();
        Scanner input = new Scanner(new File(inputFileName));

        int m = input.nextInt(), n = input.nextInt();
        input.nextLine();

        Matrix matrix = new Matrix(m,n);


        while (input.hasNextLine()) { //cita pokial nenarazi na koniec (neexistujuci prvy riadok matice)
            for (int i = 0; i < m; i++) { //ak je dalsi riadok, tak urcite bude m-riadkov matice
                String row = input.nextLine(); //jeden riadok matice
                String[] columns = row.split(" "); //rozdelenie riadku na prvky (stlpce)
                for (int j = 0; j < n; j++) { //prvky_length = n
                    matrix.addTo(i, j, columns[j]); //pricitanie do vyslednej matice
                }
            }
        }
        PrintStream output = new PrintStream(outputFileName);
        for (int i = 0; i < m; i++) { //formatovany vystup vyslednej matice
            for (int j = 0; j < n; j++) {
                output.printf("[%d,%d]: %s\n", i, j, matrix.get(i,j));
            }
        }
        input.close();
        output.close();
    }
}
