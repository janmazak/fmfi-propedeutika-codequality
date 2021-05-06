import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Matrix<T> {

    private int rows;
    private int columns;
    private LinkedList<LinkedList<T>> matrix;


    public Matrix(int rows, int columns, Scanner scanner) throws FileNotFoundException {
        // Scanner scanner = new Scanner(System.in);
        this.rows = rows;
        this.columns = columns;
        readMatrix(scanner);

    }

    public Matrix(Scanner scanner) throws FileNotFoundException {
        // Scanner scanner = new Scanner(System.in);
        this.rows = scanner.nextInt();
        this.columns = scanner.nextInt();
        readMatrix(scanner);

    }

    public Matrix(List<List<T>> matrix){
        this.matrix = new LinkedList<>();

        for (int i = 0; i < matrix.size(); i++){
            this.matrix.add(new LinkedList<>());

            for (int k = 0; k < matrix.get(0).size(); k++){
                this.matrix.get(i).add(matrix.get(i).get(k));
            }
        }

    }

    private void readMatrix(Scanner scanner){
        matrix = new LinkedList<>();

        for (int i = 0; i < this.rows; i++){
            matrix.add(new LinkedList<>());
            for (int k = 0; k < this.columns; k++){
                matrix.get(i).add(k, (T) scanner.next());
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

    public void operation(Matrix<T> matrix, BinaryOperator<T> binOp){
        if (this.rows != matrix.getRows()) throw new IllegalArgumentException();
        if (this.columns != matrix.getColumns()) throw new IllegalArgumentException();

        for (int i = 0; i < rows; i++){

            for (int k = 0; k < columns; k++){
                T pom = binOp.apply(this.matrix.get(i).get(k), matrix.getItem(i, k));
                this.matrix.get(i).set(k, pom);
            }
        }



    }


}


