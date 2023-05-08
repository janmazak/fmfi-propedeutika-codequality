import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Trieda obsahujúca testy pre triedu `ConcatenateMatrices`.
public class ConcatenateMatricesTest {
    
    // Metóda `main` na spustenie všetkých testov.
    public static void main(String[] args) {
        testConcatenateMatricesExample1();
        testConcatenateMatricesExample2();
        testConcatenateMatricesExample3();
    }

    // Test 1: Matica s jednou prázdnou bunkou.
    private static void testConcatenateMatricesExample1() {
        String input = "1 1";
        String expectedOutput =
                "[0,0]: \n";

        runTest(input, expectedOutput, "testConcatenateMatricesExample1");
    }

    // Test 2: Príklad zo zadania.
    private static void testConcatenateMatricesExample2() {
        String input = "2 3\n" +
                "ab cd ef\n" +
                "gh ij kl\n" +
                "1 2 3\n" +
                "4 5 6\n" +
                "AB CD EF\n" +
                "GH IJ KL\n";
        String expectedOutput = "[0,0]: ab1AB\n" +
                "[0,1]: cd2CD\n" +
                "[0,2]: ef3EF\n" +
                "[1,0]: gh4GH\n" +
                "[1,1]: ij5IJ\n" +
                "[1,2]: kl6KL\n";

        runTest(input, expectedOutput, "testConcatenateMatricesExample2");
    }

    // Test 3: Ďalší príklad s rôznymi reťazcami a číslami.
    private static void testConcatenateMatricesExample3() {
        String input = "3 3\n" +
                "aa b c\n" +
                "d ee f\n" +
                "g h ii\n" +
                "1 222 3\n" +
                "4 555 6\n" +
                "7 888 9\n" +
                "A B C\n" +
                "D E F\n" +
                "G H I\n";
        String expectedOutput =
                "[0,0]: aa1A\n" +
                "[0,1]: b222B\n" +
                "[0,2]: c3C\n" +
                "[1,0]: d4D\n" +
                "[1,1]: ee555E\n" +
                "[1,2]: f6F\n" +
                "[2,0]: g7G\n" +
                "[2,1]: h888H\n" +
                "[2,2]: ii9I\n";

        runTest(input, expectedOutput, "testConcatenateMatricesExample3");
    }

    // Metóda určená na spustenie jedného testu, porovnávacia skutočný a očakávaný výstup.
    private static void runTest(String input, String expectedOutput, String testName) {
        try {
            // Zapíš vstupné dáta do súboru.
            Files.write(Paths.get("vstup.txt"), input.getBytes());

            // Spusti `ConcatenateMatrices` pomocou metódy `main`.
            ConcatenateMatrices.main(new String[]{});

            // Prečítaj dáta zo súboru.
            String actualOutput = new String(Files.readAllBytes(Paths.get("vystup.txt")));

            // Porovnaj skutočný a očakávaný výstup.
            if (actualOutput.equals(expectedOutput)) {
                System.out.println(testName + ": PASSED");
            } else {
                System.out.println(testName + ": FAILED");
                System.out.println("Expected: " + expectedOutput);
                System.out.println("Actual: " + actualOutput);
            }
        } catch (IOException e) {
            System.out.println("Error running test: " + e.getMessage());
        } finally {

            // Vymaž vstupný a výstupný súbor.
            if (!new File("vstup.txt").delete()) {
                System.out.println("Failed to delete input.txt");
            }
            if (!new File("vystup.txt").delete()) {
                System.out.println("Failed to delete output.txt");
            }
        }
    }
}
