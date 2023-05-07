package test;
import org.junit.*;
import org.junit.rules.TemporaryFolder;

import main.ConcatenateMatrices;

import java.io.*;

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
    public void test01() throws IOException {

        // ConcatenateMatrices.concatenate(inputFile.getAbsolutePath(), outputFile.getAbsolutePath());

        // assertNotNull(expected);
        // assertNotNull(result);
        // assertEquals(expected, result);
    }

}
