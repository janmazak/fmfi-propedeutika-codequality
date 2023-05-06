import java.util.*;
import java.io.*;

public class ConcatenateMatrices {

    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String OUPUT_FILE_NAME = "output.txt";

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File(INPUT_FILE_NAME));
        PrintStream output = new PrintStream(OUPUT_FILE_NAME);

        /* Dimensions of matrices */
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        StringMatrix matrix = new StringMatrix(m,n);

        /* If there is an unread line in input file, it is expected to contain new matrix for concatenation. */
        while (scanner.hasNextLine()) {
            matrix.readMatrix(scanner, false);
        }

        scanner.close();

        matrix.printMatrix(output);

        output.close();
    }
}
