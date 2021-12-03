import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

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
        return getOxygenGeneratorRating(lines) * getCO2ScrubberRating(lines);
    }

    public static int getOxygenGeneratorRating(LinkedList<String> lines) {
        var table = formatInputData(lines);

        for (int i = 0; i < table.length; i++) {
            var mcb = getMostCommonBit(table[i]);
            int finalI = i;
            lines = lines.stream()
                .filter(l -> Integer.parseInt(l.split("")[finalI]) == mcb)
                .collect(Collectors.toCollection(LinkedList::new));

            table = formatInputData(lines);
        }

        return Integer.parseInt(lines.get(0), 2);
    }

    public static int getCO2ScrubberRating(LinkedList<String> lines) {
        var table = formatInputData(lines);

        for (int i = 0; i < table.length; i++) {
            var mcb = getMostCommonBit(table[i]);
            var lcb = mcb == 1 ? 0 : 1;
            int finalI = i;

            lines = lines.stream()
                .filter(l -> Integer.parseInt(l.split("")[finalI]) == lcb)
                .collect(Collectors.toCollection(LinkedList::new));

            if (lines.size() == 1) {
                break;
            }

            table = formatInputData(lines);
        }

        return Integer.parseInt(lines.get(0), 2);
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

        return (onesCount > zerosCount || onesCount == zerosCount) ? 1 : 0;
    }
}
