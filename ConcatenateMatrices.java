import java.util.*;

public class ConcatenateMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Zadajte počet riadkov a stĺpcov matice oddelené medzerou: ");
        String[] rozmery = scanner.nextLine().split(" ");
        int m = Integer.parseInt(rozmery[0]);
        int n = Integer.parseInt(rozmery[1]);

        String[][] matrix = createMatrix(m, n);
        fillMatrix(matrix, scanner);

        printMatrix(matrix);

        scanner.close();
    }

    // Creates a matrix of the given dimensions
    private static String[][] createMatrix(int m, int n) {
        String[][] matrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = "";
            }
        }
        return matrix;
    }

    // Fills the matrix by concatenating rows from the user input
    private static void fillMatrix(String[][] matrix, Scanner scanner) {
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

    // Prints the matrix to the console in a formatted way
    private static void printMatrix(String[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("[%d,%d]: %s\n", i, j, matrix[i][j]);
            }
        }
    }

    // Test method for a static input matrix
    private static void test1() {
        String[][] matrix = {{"12", "34", "56"}, {"78", "90", "12"}};
        printMatrix(matrix);
    }

    // Test method for a static input matrix
    private static void test2() {
        String[][] matrix = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        printMatrix(matrix);
    }

    // Test method for a static input matrix
    private static void test3() {
        String[][] matrix = {{"12", "34", "56"}, {"78", "90", "12"}, {"34", "56", "78"}};
        printMatrix(matrix);
    }
}

