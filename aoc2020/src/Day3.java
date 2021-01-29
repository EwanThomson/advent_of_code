import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day3 {

    public static void main(String[] args) {
        List<String> lines = readInput("/Users/ewan/Documents/GitHub/advent_of_code/day3_input.txt");
        int numTrees[] = {
                getTrees(lines, 1, 1),
                getTrees(lines, 3, 1),
                getTrees(lines, 5, 1),
                getTrees(lines, 7, 1),
                getTrees(lines, 1, 2),
        };
        long ans = 1;
        for (int numTree : numTrees) {
            System.out.print(numTree + " ");
            ans *= numTree;
        }
        System.out.println(ans);
    }

    static int getTrees(List<String> lines, int right, int down) {
        char tree = '#';
        int column = 0;
        int trees = 0;
        for (int row = 0; row < lines.size() / down; row++) {
            String line = lines.get(down * row);
            if (line.charAt(column % line.length()) == tree) {
                trees++;
            }
            column += right;
        }
        return trees;
    }

    static List<String> readInput(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}