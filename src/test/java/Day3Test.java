import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day3Test {
    LinkedList<String> input;

    @BeforeEach
    void before() {
        String data = """
            00100
            11110
            10110
            10111
            10101
            01111
            00111
            11100
            10000
            11001
            00010
            01010
            """;

        input = new LinkedList<>(Arrays.stream(data.split("\n")).toList());
    }

    @Test
    void taskOne() {
        var got = Day3.taskOne(input);
        assertEquals(198, got);
    }

    @Test
    void taskTwo() {
        var got = Day3.taskTwo(input);
        assertEquals(230, got);
    }
}