import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        InputStream input = Main.class.getClassLoader().getResourceAsStream("day2.txt");
        var output = Day2.taskTwo(input);

        System.out.println(output);
    }
}
