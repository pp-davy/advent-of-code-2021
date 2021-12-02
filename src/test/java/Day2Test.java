import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day2Test {
    LinkedList<String> input;

    @BeforeEach
    void before() {
        String data = """
            forward 5
            down 5
            forward 8
            up 3
            down 8
            forward 2
            """;

        input = new LinkedList<>(Arrays.stream(data.split("\n")).toList());
    }

    @Test
    void taskOne() {
        var got = Day2.taskOne(input);
        assertEquals(150, got);
    }

    @Test
    void taskTwo() {
        var got = Day2.taskTwo(input);
        assertEquals(900, got);
    }
}