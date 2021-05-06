import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.LinkedList;

public class Print<T> {
    private LinkedList<LinkedList<T>> matrix;
    private int rows;
    private int columns;

    public Print (Matrix<T> matrix){
        rows = matrix.getRows();
        columns = matrix.getColumns();
        this.matrix = new LinkedList<>();

        for (int i = 0; i < rows; i++){
            this.matrix.add(new LinkedList<>());
            for (int k = 0; k < columns; k++){
                this.matrix.get(i).add(matrix.getItem(i, k));
            }
        }
    }

    public void printToFile(String file) throws FileNotFoundException {
        PrintStream output = new PrintStream(file);
        for (int i = 0; i < rows; i++){
            for (int k = 0; k < columns; k++){
                output.printf("[" + i + "," + k + "]: " +  matrix.get(i).get(k));
            }
        }
        output.close();
    }

    public void printToTerminal(){
        for (int i = 0; i < rows; i++){
            for (int k = 0; k < columns; k++){
                System.out.printf("[" + i + "," + k + "]: " +  matrix.get(i).get(k));
            }
        }
    }

}
