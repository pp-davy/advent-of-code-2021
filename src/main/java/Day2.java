import java.util.LinkedList;

public class Day2 {
    public static int taskOne(LinkedList<String> lines) {
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

    public static int taskTwo(LinkedList<String> lines) {
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

}
