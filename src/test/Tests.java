package test;
import org.junit.*;
import org.junit.rules.TemporaryFolder;

import main.ConcatenateMatrices;
import main.StringMatrix;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.*;

public class Tests {

    private File inputFile, outputFile;
    private String expected, result;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() {
        try {
            inputFile = folder.newFile( "test_input.txt" );
            outputFile = folder.newFile( "test_output.txt" );
            expected = null;
            result = null;
        }
        catch(IOException e) {
            System.err.println("Error creating temporary test file.");
        }
    }

    @Test
    public void shouldReadMatrixCorrectly() {
        String inputMatrix[][] = { {"a","b","c"}, {"k","l","m"}, {"x","y","z"} };

        StringBuilder sb = new StringBuilder();
        for (String line[] : inputMatrix) {
            for (String element : line) {
                sb.append(element + " ");
            }
        }
        Scanner scanner = new Scanner(sb.toString());

        StringMatrix matrix = new StringMatrix(3, 3);
        matrix.readMatrix(scanner, false);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(inputMatrix[i][j], matrix.getElement(i, j));
            }
        }
    }
}
