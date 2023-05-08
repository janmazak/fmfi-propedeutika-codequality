import java.util.*;

public class ConcatenateMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //test1();
        //test2();
        //test3();

        System.out.print("Zadajte počet riadkov a stĺpcov matice oddelené medzerou: ");
        String[] rozmery = scanner.nextLine().split(" ");
        int m = Integer.parseInt(rozmery[0]);
        int n = Integer.parseInt(rozmery[1]);

        Matrix matrix = new Matrix(m, n);
        matrix.fillMatrix(scanner);

        matrix.printMatrix();

        scanner.close();
    }

    // Test method for a static input matrix
    private static void test1() {
        String[][] matrixData = {{"12", "34", "56"}, {"78", "90", "12"}};
        Matrix matrix = new Matrix(matrixData);
        matrix.printMatrix();
    }

    // Test method for a static input matrix
    private static void test2() {
        String[][] matrixData = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        Matrix matrix = new Matrix(matrixData);
        matrix.printMatrix();
    }

    // Test method for a static input matrix
    private static void test3() {
        String[][] matrixData = {{"12", "34", "56"}, {"78", "90", "12"}, {"34", "56", "78"}};
        Matrix matrix = new Matrix(matrixData);
        matrix.printMatrix();
    }
}

class Matrix {
    private String[][] matrix;

    public Matrix(int m, int n) {
        matrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = "";
            }
        }
    }

    public Matrix(String[][] matrixData) {
        int m = matrixData.length;
        int n = matrixData[0].length;
        matrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(matrixData[i], 0, matrix[i], 0, n);
        }
    }

    public void fillMatrix(Scanner scanner) {
        System.out.println("Zadajte prvky matice oddelené medzerou:");

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            String[] prvky = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] += prvky[j];
            }
        }
    }

    public void printMatrix() {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("[%d,%d]: %s\n", i, j, matrix[i][j]);
            }
        }
    }
}
