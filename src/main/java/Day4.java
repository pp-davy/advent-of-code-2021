import java.util.Arrays;
import java.util.LinkedList;
import org.apache.maven.surefire.shade.org.apache.commons.lang3.tuple.ImmutablePair;

public class Day4 {
    public static int taskOne(LinkedList<String> lines) {
        LinkedList<int[][]> boards = getAllBoards(lines);
        int[] numbers = getNumbers(lines);

        int winningNumber = 0;
        int[][] winningBoard = new int[0][];

        for (int n : numbers) {
            updateBoards(boards, n);
            var result = haveWinner(boards);
            if (result.getLeft()) {
                winningNumber = n;
                winningBoard = boards.get(result.getRight());
                break;
            }
        }

        return sumWinningBoardUnmarkedNumbers(winningBoard) * winningNumber;
    }

    public static int taskTwo(LinkedList<String> lines) {
        LinkedList<int[][]> boards = getAllBoards(lines);
        int[] numbers = getNumbers(lines);

        int winningNumber = 0;
        int[][] winningBoard = new int[0][];

        for (int n : numbers) {
            updateBoards(boards, n);
            if (boards.size() == 1) {
                winningNumber = n;
                winningBoard = boards.get(0);
                break;
            }

            boards.removeIf(board -> checkRows(board) || checkColumns(board));
        }

        return sumWinningBoardUnmarkedNumbers(winningBoard) * winningNumber;
    }

    public static int[] getNumbers(LinkedList<String> lines) {
        return Arrays.stream(lines.get(0).split(","))
            .mapToInt(Integer::parseInt)
            .toArray();
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
        return Arrays.stream(board)
            .flatMapToInt(Arrays::stream)
            .filter(i -> i != -1)
            .sum();
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
            }
        }

        return false;
    }

    private static LinkedList<int[][]> getAllBoards(LinkedList<String> lines) {
        LinkedList<int[][]> boards = new LinkedList<>();
        int boardLineLength = 6;

        for (int offset = 2; offset < lines.size(); offset += boardLineLength) {
            boards.add(getNextBoard(lines, offset));
        }

        return boards;
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("-".repeat(board.length * 4));
    }
}
