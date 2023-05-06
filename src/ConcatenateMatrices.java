import java.util.*;
import java.io.*;

public class ConcatenateMatrices {

    private static final String DEFAULT_INPUT_FILE_NAME = "input.txt";
    private static final String DEFAULT_OUPUT_FILE_NAME = "output.txt";

    public static void main(String[] args) {

        run(DEFAULT_INPUT_FILE_NAME, DEFAULT_OUPUT_FILE_NAME);

    }

    public static void run(String inputFileName, String outputFileName) {
        Scanner scanner = null;
        PrintStream output = null;

        try {
            scanner = new Scanner(new File(inputFileName));
            output = new PrintStream(outputFileName);

            /* Dimensions of matrices */
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            StringMatrix matrix = new StringMatrix(m,n);

            /* If there is an unread line in input file, it is expected to contain new matrix for concatenation. */
            while (scanner.hasNextLine()) {
                matrix.readMatrix(scanner, false);
            }

            matrix.printMatrix(output);

        } catch (IOException e) {
            System.err.println("Error with opening input and output files.");

        } catch (NoSuchElementException e) {
            System.err.println("Error with reading matrix dimensions.");

        }
        finally {
            if (scanner != null) scanner.close();
            if (output != null) output.close();
        }
    }
}
