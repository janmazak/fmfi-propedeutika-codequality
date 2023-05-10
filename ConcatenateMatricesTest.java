import org.junit.Test;
import org.junit.Assert;
import java.io.IOException;

public class ConcatenateMatricesTest {

    @Test
    public void testExampleInput() throws IOException {
        String[] file = new String[]{"vstup1.txt"};
        ConcatenateMatrices.main(file);
        String expectedOutput = """
                [0,0]: ab1AB
                [0,1]: cd2CD
                [0,2]: ef3EF
                [1,0]: gh4GH
                [1,1]: ij5IJ
                [1,2]: kl6KL
                """;
        String actualOutput = TestUtils.getOutput("vystup.txt");
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMissingInputFile() throws IOException {
        String[] file = new String[]{"vstup2.txt"};
        TestUtils.deleteFileIfExists("vstup2.txt");
        try {
            ConcatenateMatrices.main(file);
        } catch (IOException e) {
            String expectedOutput = "";
            String actualOutput = TestUtils.getOutput("vystup.txt");
            Assert.assertEquals(expectedOutput, actualOutput);
        }
        TestUtils.createFileIfNotExists("vstup2.txt");
    }

    @Test
    public void testIncorrectInputFormat() throws IOException {
        String[] file = new String[]{"vstup3.txt"};
        TestUtils.setInput("1 1\n1\n2");
        try {
            ConcatenateMatrices.main(file);
        } catch (ArrayIndexOutOfBoundsException e) {
            String expectedOutput = "";
            String actualOutput = TestUtils.getOutput("vystup.txt");
            Assert.assertEquals(expectedOutput, actualOutput);
        }
    }

    @Test
    public void testLargeInput() throws IOException {
        String[] file = new String[]{"vstup4.txt"};
        StringBuilder inputBuilder = new StringBuilder();
        inputBuilder.append("1000 1000\n");
        for (int i = 0; i < 1000; i++) {
            inputBuilder.append("1 ".repeat(1000));
            inputBuilder.append("\n");
        }
        TestUtils.setInput(inputBuilder.toString());
        ConcatenateMatrices.main(file);
        String actualOutput = TestUtils.getOutput("vystup.txt");
        Assert.assertTrue(actualOutput.length() > 0);
    }
}
