import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class Day2 {
    public static int taskOne(InputStream input) {
        final var lines = getLines(input);
        var horizontalPosition = 0;
        var depth = 0;

        for (String line : lines) {
            var lineElements = line.split(" ");
            var direction = lineElements[0];
            var moveAmount = lineElements[1];

            switch (direction) {
                case "forward" -> horizontalPosition += Integer.parseInt(moveAmount);
                case "down" -> depth += Integer.parseInt(moveAmount);
                case "up" -> depth -= Integer.parseInt(moveAmount);
            }
        }

        return horizontalPosition * depth;
    }

    public static int taskTwo(InputStream input) {
        final var lines = getLines(input);
        var horizontalPosition = 0;
        var depth = 0;
        var aim = 0;

        for (String line : lines) {
            var lineElements = line.split(" ");
            var direction = lineElements[0];
            var moveAmount = Integer.parseInt(lineElements[1]);

            switch (direction) {
                case "forward" -> {
                    horizontalPosition += moveAmount;
                    depth += aim * moveAmount;
                }
                case "down" -> aim += moveAmount;
                case "up" -> aim -= moveAmount;
            }
        }

        return horizontalPosition * depth;
    }

    private static LinkedList<String> getLines(InputStream input) {
        InputStreamReader streamReader = new InputStreamReader(input, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        return new LinkedList<>(reader.lines().toList());
    }
}
