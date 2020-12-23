import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day1 {
    public static void main(String[] args) {
        List<String> lines = readInput("/Users/ewan/Documents/GitHub/advent_of_code/day1_input.txt");
        List<Integer> numbers = new ArrayList<>();
        for (String line : lines) {
            numbers.add(Integer.parseInt(line));
        }
        int ans = -1;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(i) + numbers.get(j) == 2020) {
                    ans = numbers.get(i) * numbers.get(j);
                }
            }
        }
        System.out.println(ans);
    }

    static List<String> readInput(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
