import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ConcatenateMatricesTest {

    // Test when input file is empty
    @Test
    void testEmptyFile() throws IOException {
        // Create empty input and output files
        File input = new File("vstup.txt");
        File output = new File("vystup.txt");
        input.createNewFile();
        output.createNewFile();

        // Call the main method
        ConcatenateMatrices.main(new String[]{});

        // Assert that the output file is empty
        Scanner scanner = new Scanner(output);
        assertFalse(scanner.hasNextLine());
        scanner.close();

        // Clean up the files
        input.delete();
        output.delete();
    }

    // Test when input file has only one matrix
    @Test
    void testSingleMatrix() throws IOException {
        // Create input file
        File input = new File("vstup.txt");
        PrintWriter inputWriter = new PrintWriter(input);
        inputWriter.println("2 3");  // Matrix dimensions
        inputWriter.println("1 2 3"); // Matrix row 1
        inputWriter.println("4 5 6"); // Matrix row 2
        inputWriter.close();

        // Create expected output
        String expected = "[0,0]: 1\n" +
                "[0,1]: 2\n" +
                "[0,2]: 3\n" +
                "[1,0]: 4\n" +
                "[1,1]: 5\n" +
                "[1,2]: 6\n";

        // Call the main method
        ConcatenateMatrices.main(new String[]{});

        // Assert that the output file matches the expected output
        File output = new File("vystup.txt");
        Scanner scanner = new Scanner(output);
        assertEquals(expected, scanner.useDelimiter("\\A").next());
        scanner.close();

        // Clean up the files
        input.delete();
        output.delete();
    }

    // Test when input file has multiple matrices
    @Test
    void testMultipleMatrices() throws IOException {
        // Create input file
        File input = new File("vstup.txt");
        PrintWriter inputWriter = new PrintWriter(input);
        inputWriter.println("2 2");  // Matrix dimensions
        inputWriter.println("1 2");  // Matrix row 1
        inputWriter.println("3 4");  // Matrix row 2
        inputWriter.println("5 6");  // Matrix row 1
        inputWriter.println("7 8");  // Matrix row 2
        inputWriter.close();

        // Create expected output
        String expected = "[0,0]: 15\n" +
                "[0,1]: 26\n" +
                "[1,0]: 37\n" +
                "[1,1]: 48\n";

        // Call the main method
        ConcatenateMatrices.main(new String[]{});

        // Assert that the output file matches the expected output
        File output = new File("vystup.txt");
        Scanner scanner = new Scanner(output);
        assertEquals(expected, scanner.useDelimiter("\\A").next());
        scanner.close();

        // Clean up the files
        input.delete();
        output.delete();
    }
}
