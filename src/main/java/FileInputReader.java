import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileInputReader {
    public static ArrayList<String> readFile(String filePath) {

        ArrayList<String> lines = new ArrayList<>();
        String filepath = filePath;
//        ArrayList<String> inputArray = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println("no file?");
        }
        return lines;
    }
}
