import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day2Test {
    String input;

    @BeforeEach
    void before() {
        input = """
            forward 5
            down 5
            forward 8
            up 3
            down 8
            forward 2
            """;
    }

    @Test
    void taskOne() {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        var got = Day2.taskOne(inputStream);
        assertEquals(150, got);
    }

    @Test
    void taskTwo() {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        var got = Day2.taskTwo(inputStream);
        assertEquals(900, got);
    }
}