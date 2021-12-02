import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day1Test {
    LinkedList<String> input;

    @BeforeEach
    void before() {
        String data = """
            199
            200
            208
            210
            200
            207
            240
            269
            260
            263
            """;

        input = new LinkedList<>(Arrays.stream(data.split("\n")).toList());
    }

    @Test
    void taskOne() {
        var got = Day1.taskOne(input);
        assertEquals(7, got);
    }

    @Test
    void taskTwo() {
        var got = Day1.taskTwo(input);
        assertEquals(5, got);
    }
}