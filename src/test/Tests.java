package test;

import org.junit.*;
import org.junit.rules.TemporaryFolder;
import static org.junit.Assert.*;

import main.*;
import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Tests {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void readSingleMatrixCorrectly() {
        /* Tests whether method readMatrix from StringMatrix class can read single 2x3 matrix. */
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
    public void concatenateMatricesCorrectly() {
        /* Tests whether method readMatrix from StringMatrix class can concatenate three
         * 2x3 matrices by repeated calling. */
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
    

    @Test(expected = IllegalArgumentException.class)
    public void throwExcpetionWhenReadingWrongMatrix() {
        /* Tests whether method readMatrix from StringMatrix class throws exception when there
         * is ot enough elements to be read. */
        Scanner scanner = new Scanner("1 2 3 4");

        StringMatrix matrix = new StringMatrix(3, 3);
        matrix.readMatrix(scanner, false);
    }

    @Test
    public void replaceWhenReadingMatrix() {
        /* Tests whether method readMatrix from StringMatrix class can replace matrix correctly
         * (replace = true). */
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
            matrix.readMatrix(scanner, true);
        }

        String expectedMatrix[][] = {
            {"AB", "CD", "EF"},
            {"GH", "IJ", "KL"}
        };
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(expectedMatrix[i][j], matrix.getElement(i, j));
            }
        }
    }

    @Test
    public void printMatrixCorrectly() throws IOException {
        /* Tests whether method printMatrix from StringMatrix class prints matrix as expected. */
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
        File outputFile = folder.newFile("test_output.txt");

        StringMatrix matrix = new StringMatrix(2, 3);
        matrix.readMatrix(scanner, false);
        matrix.printMatrixElements(new PrintStream(outputFile));

        String expected = "[0,0]: ab\n[0,1]: cd\n[0,2]: ef\n[1,0]: gh\n[1,1]: ij\n[1,2]: kl\n";
        String result = Files.readString(outputFile.toPath());
        assertEquals(expected, result);
    }

    @Test
    public void integrationTest() throws IOException {
        /* Integration test for concatenate method in ConcatenateMatrices class. */
        String input[] = {
            "2 3",
            "ab cd ef",
            "gh ij kl",
            "1 2 3",
            "4 5 6",
            "AB CD EF",
            "GH IJ KL"
        };

        File inputFile = folder.newFile("test_input.txt");
        File outputFile = folder.newFile("test_output.txt");
        PrintStream ps = new PrintStream(inputFile);
        for (String line : input) ps.println(line);
        ps.close();

        ConcatenateMatrices.concatenate(inputFile.getAbsolutePath(), outputFile.getAbsolutePath());

        String expected = "[0,0]: ab1AB\n[0,1]: cd2CD\n[0,2]: ef3EF\n[1,0]: gh4GH\n[1,1]: ij5IJ\n[1,2]: kl6KL\n";
        String result = Files.readString(outputFile.toPath());
        assertEquals(expected, result);
    }
}
