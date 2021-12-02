import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day1Test {
    String input;

    @BeforeEach
    void before() {
        input = """
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
    }

    @Test
    void taskOne() {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        var got = Day1.taskOne(inputStream);
        assertEquals(7, got);
    }

    @Test
    void taskTwo() {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        var got = Day1.taskTwo(inputStream);
        assertEquals(5, got);
    }
}