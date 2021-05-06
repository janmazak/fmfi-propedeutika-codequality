import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Matrix<T> {

    private int rows;
    private int columns;
    private LinkedList<LinkedList<T>> matrix;

    //konštruktor na nacitavanie matice z konzoly
    public Matrix(int rows, int columns, Scanner scanner) throws FileNotFoundException {
        // Scanner scanner = new Scanner(System.in);
        this.rows = rows;
        this.columns = columns;
        matrix = new LinkedList<>();

        for (int i = 0; i < this.rows; i++){
            matrix.add(new LinkedList<>());
            for (int k = 0; k < this.columns; k++){
                matrix.get(i).add(k, (T) scanner.next());
            }
        }

        scanner.close();
    }

    //konstruktor na nacitavanie matice zo suboru
    /*
    public Matrix(String file, int rows, int columns) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(file));
        this.rows = rows;
        this.columns = columns;
        matrix = new LinkedList<>();

        for (int i = 0; i < this.rows; i++){
            matrix.add(new LinkedList<>());
            for (int k = 0; k < this.columns; k++){
                matrix.get(i).add(k, (T) scanner.next());
            }
        }

        scanner.close();
    }

     */


    public Matrix(List<List<T>> matrix){
        this.matrix = new LinkedList<>();

        for (int i = 0; i < matrix.size(); i++){
            this.matrix.add(new LinkedList<>());

            for (int k = 0; k < matrix.get(0).size(); k++){
                this.matrix.get(i).add(matrix.get(i).get(k));
            }
        }

    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public T getItem (int row, int column){
        return this.matrix.get(row).get(column);
    }

}


