import org.junit.Test;
import org.junit.Assert;
import java.io.IOException;

public class ConcatenateMatricesTest {

    @Test
    public void testExampleInput() throws IOException {
        ConcatenateMatrices.main(null);
        String expectedOutput = "[0,0]: ab1AB\n" +
                                "[0,1]: cd2CD\n" +
                                "[0,2]: ef3EF\n" +
                                "[1,0]: gh4GH\n" +
                                "[1,1]: ij5IJ\n" +
                                "[1,2]: kl6KL\n";
        String actualOutput = TestUtils.getOutput("vystup.txt");
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMissingInputFile() throws IOException {
        TestUtils.deleteFileIfExists("vstup2.txt");
        try {
            ConcatenateMatrices.main(null);
        } catch (IOException e) {
            String expectedOutput = "";
            String actualOutput = TestUtils.getOutput("vystup.txt");
            Assert.assertEquals(expectedOutput, actualOutput);
        }
    }

    @Test
    public void testIncorrectInputFormat() throws IOException {
        TestUtils.setInput("1 1\n1\n2");
        try {
            ConcatenateMatrices.main(null);
        } catch (ArrayIndexOutOfBoundsException e) {
            String expectedOutput = "";
            String actualOutput = TestUtils.getOutput("vystup.txt");
            Assert.assertEquals(expectedOutput, actualOutput);
        }
    }

    @Test
    public void testLargeInput() throws IOException {
        StringBuilder inputBuilder = new StringBuilder();
        inputBuilder.append("1000 1000\n");
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                inputBuilder.append("1 ");
            }
            inputBuilder.append("\n");
        }
        TestUtils.setInput(inputBuilder.toString());
        ConcatenateMatrices.main(null);
        String actualOutput = TestUtils.getOutput("vystup.txt");
        Assert.assertTrue(actualOutput.length() > 0);
    }
}
