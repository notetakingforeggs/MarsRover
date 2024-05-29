import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String filepath = "/home/ludic/northcoders/fundamentals/MarsRover/src/main/resources/input.csv";
        FileInputReader.readFile(filepath);

//        ArrayList<String> lines = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
//                String line = reader.readLine();
//                while (line != null){
//                    lines.add(line);
//                    line = reader.readLine();
//                }
//
//        } catch (IOException e) {
//            System.out.println("no file?");
//        }
//lines.stream().forEach(System.out::println);

    }
}
