import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        var filename = "day3.txt";
        var inputStream = open(filename);
        var input = getLines(inputStream);
        if (input.size() == 0) {
            throw new RuntimeException("failed to parse input file");
        }

        var output = Day3.taskOne(input);
        System.out.println(output);
    }

    public static InputStream open(String filename) {
        return Main.class.getClassLoader().getResourceAsStream(filename);
    }

    public static LinkedList<String> getLines(InputStream input) {
        InputStreamReader streamReader = new InputStreamReader(input, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        return new LinkedList<>(reader.lines().toList());
    }
}
