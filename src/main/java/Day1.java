import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class Day1 {
    public static int taskOne(InputStream input) {
        var lines = getLines(input);
        var prev = Integer.parseInt(lines.pop());
        var count = 0;

        for (String line : lines) {
            var lineAsInt = Integer.parseInt(line);

            if (lineAsInt > prev) {
                count++;
            }

            prev = lineAsInt;
        }

        return count;
    }

    public static int taskTwo(InputStream input) {
        var lines = getLines(input);
        var prev = Integer.MAX_VALUE;
        var count = 0;

        for (int i = 0; i < lines.size() - 2; i++) {
            var a = Integer.parseInt(lines.get(i));
            var b = Integer.parseInt(lines.get(i + 1));
            var c = Integer.parseInt(lines.get(i + 2));
            var sum = a + b + c;

            if (sum > prev) {
                count++;
            }

            prev = sum;
        }

        return count;
    }

    private static LinkedList<String> getLines(InputStream input) {
        InputStreamReader streamReader = new InputStreamReader(input, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        return new LinkedList<>(reader.lines().toList());
    }
}
