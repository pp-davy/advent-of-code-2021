import java.util.LinkedList;

public class Day1 {
    public static int taskOne(LinkedList<String> lines) {
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

    public static int taskTwo(LinkedList<String> lines) {
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
}
