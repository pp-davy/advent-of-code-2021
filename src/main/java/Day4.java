import java.util.Arrays;
import java.util.LinkedList;
import org.apache.maven.surefire.shade.org.apache.commons.lang3.tuple.ImmutablePair;

public class Day4 {
    public static int taskOne(LinkedList<String> lines) {
        LinkedList<int[][]> boards = getAllBoards(lines);
        int[] numbers = getNumbers(lines);

        int winningNumber = 0;
        int[][] winningBoard = new int[0][];

        for (int num : numbers) {
            updateBoards(boards, num);
            var result = haveWinner(boards);
            if (result.getLeft()) {
                winningNumber = num;
                winningBoard = boards.get(result.getRight());
                break;
            }
        }

//        boards.forEach(Day4::printBoard);

        return sumWinningBoardUnmarkedNumbers(winningBoard) * winningNumber;
    }

    private static void updateBoards(final LinkedList<int[][]> boards, final int num) {
        for (int[][] board : boards) {
            for (int[] row : board) {
                for (int i = 0; i < row.length; i++) {
                    if (row[i] == num) {
                        row[i] = -1;
                    }
                }
            }
        }
    }

    private static int sumWinningBoardUnmarkedNumbers(final int[][] board) {
        int sum = 0;
        for (int[] row : board) {
            for (int i : row) {
                if (i == -1) {
                    continue;
                }
                sum += i;
            }
        }
        return sum;
    }

    private static ImmutablePair<Boolean, Integer> haveWinner(final LinkedList<int[][]> boards) {
        for (int[][] board : boards) {
            if (checkRows(board) || checkColumns(board)) {
                return new ImmutablePair<>(true, boards.indexOf(board));
            }
        }

        return new ImmutablePair<>(false, -1);
    }

    private static Boolean checkRows(final int[][] board) {
        for (int[] row : board) {
            if (Arrays.stream(row).filter(e -> e != -1).count() == 0) {
                return true;
            }
        }
        return false;
    }

    private static Boolean checkColumns(final int[][] board) {
        for (int i = 0; i < 5; i++) {
            int[] columnValues = new int[5];
            for (int j = 0; j < 5; j++) {
                columnValues[j] = board[j][i];
            }

            if (Arrays.stream(columnValues).filter(e -> e != -1).count() == 0) {
               return true;
            };
        }

        return false;
    }

    public static int taskTwo(LinkedList<String> lines) {
        return 0;
    }

    public static int[] getNumbers(LinkedList<String> lines) {
        var numberLine = lines.get(0).split(",");
        var output = new int[numberLine.length];

        for (int i = 0; i < output.length; i++) {
            output[i] = Integer.parseInt(numberLine[i]);
        }

        return output;
    }

    private static LinkedList<int[][]> getAllBoards(LinkedList<String> lines) {
        LinkedList<int[][]> boards = new LinkedList<>();
        int boardLength = 6;

        for (int offset = 2; offset < lines.size(); offset += boardLength) {
            boards.add(getNextBoard(lines, offset));
        }

        return boards;
    }

    public static int[][] getNextBoard(LinkedList<String> lines, int offset) {
        int[][] output = new int[5][5];

        for (int lineNum = offset, i = 0; lineNum < 5 + offset; lineNum++, i++) {
            output[i] = Arrays.stream(lines.get(lineNum)
                    .strip()
                    .replace("  ", " ")
                    .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        return output;
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("-".repeat(board.length * 4));
    }
}
