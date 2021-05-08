import java.util.*;
import java.io.*;

public class ConcatenateMatrices {

    public static void main(String[] args){

        Scanner scanner = null;
        PrintStream output = null;
        try {
            scanner = new Scanner(new File("vstup.txt"));
            output = new PrintStream("vystup.txt");
        }
        catch (Exception e){
            System.out.println("Problem s nacitanim/vytvorenim vstupneho/vystupneho suboru.");
            if(scanner != null) scanner.close();
            if(output != null) output.close();
            return;
        }

        int m, n;
        try {
            m = scanner.nextInt();
            n = scanner.nextInt();
            if(m < 1 || n < 1) throw new IllegalArgumentException();
        }
        catch (Exception e){
            System.out.println("Nespravne rozmery matic.");
            if(scanner != null) scanner.close();
            if(output != null) output.close();
            return;
        }

        String[][] matrix = new String[m][n]; //matica a jej vynulovanie
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = "";
            }
        }

        while (scanner.hasNextLine()) { //cita pokial nenarazi na koniec (neexistujuci prvy riadok matice)
            for (int i = 0; i < m; i++) {
                if(!scanner.hasNextLine()){
                    System.out.println("Nedostatocny pocet zadanych riadkov matice.");
                    if(scanner != null) scanner.close();
                    if(output != null) output.close();
                    return;
                }
                String riadok = scanner.nextLine(); //jeden riadok matice
                String[] prvky = riadok.split(" "); //rozdelenie riadku na prvky (stlpce)
                if(prvky.length != n){
                    System.out.println("Nespravny pocet prvkov v riadku.");
                    if(scanner != null) scanner.close();
                    if(output != null) output.close();
                    return;
                }
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
        if(scanner != null) scanner.close();
        if(output != null) output.close();
    }
}
