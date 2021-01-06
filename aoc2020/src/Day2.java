import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day2 {
    public static void main(String[] args) {
        List<String> lines = readInput("/Users/ewan/Documents/GitHub/advent_of_code/day2_input.txt");
        int valid = 0;
        for (String line : lines) {
            String[] split = line.split(": ");
            String rule = split[0];
            String password = split[1];
            split = rule.split(" ");
            String range = split[0];
            char character = split[1].charAt(0);
            split = range.split("-");
            int low = Integer.parseInt(split[0]);
            int high = Integer.parseInt(split[1]);

            int count = 0;
            for (char c : password.toCharArray()) {
                if (c == character) {
                    count++;
                }
            }

            if (count >= low && count <= high) {
                valid++;
            }
        }
        System.out.println(valid);
    }

    static List<String> readInput(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
