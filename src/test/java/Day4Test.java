import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day4Test {
    LinkedList<String> inputOne;
    LinkedList<String> inputTwo;

    @BeforeEach
    void before() {
        String dataOne = """
            7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1
                        
            22 13 17 11  0
             8  2 23  4 24
            21  9 14 16  7
             6 10  3 18  5
             1 12 20 15 19

             3 15  0  2 22
             9 18 13 17  5
            19  8  7 25 23
            20 11 10 24  4
            14 21 16 12  6
                        
            14 21 17 24  4
            10 16 15  9 19
            18  8 23 26 20
            22 11 13  6  5
             2  0 12  3  7
            """;

        String dataTwo = """
            7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1
                        
            22 13 17 11  0
             8  2 23  4 24
            21  9 14 16  7
             6 10  3 18  5
             1 12 20 15 24

             3 15  0  2 22
             9 18 13 17  5
            19  8  7 25 23
            20 11 10 24  4
            14 21 16 12  6
                        
            14 21 17 25  4
            10 16 15  9 19
            18  8 23 26 20
            22 11 13  6  5
             2  0 12  3  7
            """;

        inputOne = new LinkedList<>(Arrays.stream(dataOne.split("\n")).toList());
        inputTwo = new LinkedList<>(Arrays.stream(dataTwo.split("\n")).toList());
    }

    @Test
    void taskOneRowCheck() {
        var got = Day4.taskOne(inputOne);
        assertEquals(4512, got);
    }

    @Test
    void taskOneColumnCheck() {
        var got = Day4.taskOne(inputTwo);
        assertEquals(3456, got);
    }

    @Test
    void getNumbers() {
        var got = Day4.getNumbers(inputOne);
        var want = new int[]{
            7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1
        };
        assertArrayEquals(want, got);
    }

    @ParameterizedTest
    @MethodSource("getNextBoardArgs")
    void getNextBoard(int offset, int[][] want) {
        var got = Day4.getNextBoard(inputOne, offset);

        for (int i = 0; i < want.length; i++) {
            assertArrayEquals(want[i], got[i]);
        }
    }

    private static Stream<Arguments> getNextBoardArgs() {
        return Stream.of(
            arguments(2, new int[][]{
                {22, 13, 17, 11, 0},
                {8, 2, 23, 4, 24},
                {21, 9, 14, 16, 7},
                {6, 10, 3, 18, 5},
                {1, 12, 20, 15, 19},
            }),
            arguments(8, new int[][]{
                {3, 15, 0, 2, 22},
                {9, 18, 13, 17, 5},
                {19, 8, 7, 25, 23},
                {20, 11, 10, 24, 4},
                {14, 21, 16, 12, 6},
            }),
            arguments(14, new int[][]{
                {14, 21, 17, 24, 4},
                {10, 16, 15, 9, 19},
                {18, 8, 23, 26, 20},
                {22, 11, 13, 6, 5},
                {2, 0, 12, 3, 7}
            })
        );
    }

    @Test
    void taskTwo() {
        var got = Day4.taskTwo(inputOne);
        assertEquals(1924, got);
    }
}