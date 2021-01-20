import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day3 {

    public static void main(String[] args) {
        List<String> lines = readInput("/Users/ewan/Documents/GitHub/advent_of_code/day3_input.txt");
        char tree = '#';
        int column = 0;
        int trees = 0;
        for (String line : lines) {
            if (line.charAt(column) == tree) {
                trees++;
            }
            column += 3;
        }
        System.out.println(trees);
    }

    static List<String> readInput(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}