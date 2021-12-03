import java.util.Arrays;
import java.util.LinkedList;

public class Day3 {
    public static int taskOne(LinkedList<String> lines) {
        var table = formatInputData(lines);

        var gamma = new StringBuilder();
        var epsilon = new StringBuilder();

        for (int[] i : table) {
            var mcb = getMostCommonBit(i);
            var lcb = mcb == 1 ? 0 : 1;
            gamma.append(mcb);
            epsilon.append(lcb);
        }

        var decimalGamma = Integer.parseInt(gamma.toString(), 2);
        var decimalEpsilon = Integer.parseInt(epsilon.toString(), 2);

        return decimalGamma * decimalEpsilon;
    }

    public static int taskTwo(LinkedList<String> lines) {
//        var table = formatInputData(lines);
//        System.out.println(Arrays.deepToString(table));
        return 0;
    }

    private static int[][] formatInputData(final LinkedList<String> lines) {
        int[][] table = new int[lines.get(0).length()][lines.size()];

        for (int i = 0; i < lines.get(0).length(); i++) {
            for (int j = 0; j < lines.size(); j++) {
                table[i][j] = Integer.parseInt((lines.get(j).split("")[i]));

            }
        }

        return table;
    }

    private static int getMostCommonBit(int[] column) {
        var onesCount = 0;
        var zerosCount = 0;

        for (int i : column) {
            if (i == 1) {
                onesCount++;
            } else {
                zerosCount++;
            }
        }

        return (onesCount > zerosCount) ? 1 : 0;
    }
}
