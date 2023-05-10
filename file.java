import java.io.*;

public class file {
    public static void main(String[] args) {
        StringBuilder inputBuilder = new StringBuilder();

        // Build input string
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                inputBuilder.append("1 ");
            }
            inputBuilder.append("\n");
        }

        // Write input string to file
        try {
            FileWriter writer = new FileWriter("vstup4.txt");
            writer.write(inputBuilder.toString());
            writer.close();
            System.out.println("Output written to vstup4.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
    }
}
