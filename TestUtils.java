import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class TestUtils {
    public static void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void setOutput(String filename) throws IOException {
        System.setOut(new PrintStream(new File(filename)));
    }

    public static String getOutput(String filename) throws IOException {
        try (InputStream stream = new FileInputStream(filename)) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = stream.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return new String(baos.toByteArray());
        }
    }

    public static void deleteFileIfExists(String filename) throws IOException {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }
}
