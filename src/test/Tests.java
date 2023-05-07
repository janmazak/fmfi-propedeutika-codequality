package test;
import org.junit.*;
import org.junit.rules.TemporaryFolder;
import static org.junit.Assert.*;

import main.*;
import java.io.*;
import java.util.*;

public class Tests {

    // private File inputFile, outputFile;

    // @Rule
    // public TemporaryFolder folder = new TemporaryFolder();

    // @Before
    // public void setUp() {
    //     try {
    //         inputFile = folder.newFile( "test_input.txt" );
    //         outputFile = folder.newFile( "test_output.txt" );
    //     }
    //     catch(IOException e) {
    //         System.err.println("Error creating temporary test file.");
    //     }
    // }

    @Test
    /* Tests method readMatrix from StringMatrix class, whether it can read single 2x3 matrix. */
    public void shouldReadMatrixCorrectly() {
        String inputMatrix[][] = {
            {"ab","cd","ef"},
            {"gh","ij","kl"}
        };

        StringBuilder sb = new StringBuilder();
        for (String line[] : inputMatrix) {
            for (String element : line) {
                sb.append(element + " ");
            }
        }
        Scanner scanner = new Scanner(sb.toString());

        StringMatrix matrix = new StringMatrix(2, 3);
        matrix.readMatrix(scanner, false);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(inputMatrix[i][j], matrix.getElement(i, j));
            }
        }
    }

    @Test
    /* Tests further method readMatrix from StringMatrix class, whether it can concatenate three
     * 2x3 matrices by repeated calling. */
    public void shoulConcatenateMatrixCorrectly() {
        String inputMatrices[][] = {
            {"ab","cd","ef"},
            {"gh","ij","kl"},
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"AB","CD","EF"},
            {"GH","IJ","KL"}
        };

        StringBuilder sb = new StringBuilder();
        for (String line[] : inputMatrices) {
            for (String element : line) {
                sb.append(element + " ");
            }
        }
        Scanner scanner = new Scanner(sb.toString());

        StringMatrix matrix = new StringMatrix(2, 3);

        while (scanner.hasNext()) {
            matrix.readMatrix(scanner, false);
        }

        String expectedMatrix[][] = {
            {"ab1AB", "cd2CD", "ef3EF"},
            {"gh4GH", "ij5IJ", "kl6KL"}
        };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(expectedMatrix[i][j], matrix.getElement(i, j));
            }
        }
    }
}
