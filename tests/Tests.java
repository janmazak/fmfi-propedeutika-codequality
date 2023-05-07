import org.junit.*;
import org.junit.rules.TemporaryFolder;
import java.io.*;
import java.nio.file.Files;

import static org.junit.Assert.*;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Tests {

    File inputFile, outputFile, testIn, testOut;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() {
        try {
            inputFile = folder.newFile( "test_input.txt" );
            outputFile = folder.newFile( "test_output.txt" );
        }
        catch(IOException e) {
            System.err.println("Error creating temporary test file.");
        }
    }

    @Test
    public void test01() {
        try {
            testIn = new File("test01_in.txt");
            testOut = new File("test01_out.txt");
    
            Files.copy(testIn.toPath(), inputFile.toPath());

            ConcatenateMatrices.run(inputFile.getAbsolutePath(), outputFile.getAbsolutePath());

            assertEquals(
                new String(Files.readAllBytes(outputFile.toPath()), UTF_8),
                new String(Files.readAllBytes(testOut.toPath()), UTF_8)
            );
        }
        catch (Exception e) {
            System.err.println("Error during test number 01.");
        }
    }
}
