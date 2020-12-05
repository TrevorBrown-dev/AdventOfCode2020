import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.Line;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        int treeCount = 0;

        try {
            File f = new File("in.txt");
            Scanner scan = new Scanner(f);
            ArrayList<char[]> slope = new ArrayList<>();
            while (scan.hasNextLine()) {
                char[] line = scan.nextLine().toCharArray();
                slope.add(line);
            }

            Character[][] grid = new Character[slope.size()][slope.get(0).length];
            for (int r = 0; r < slope.size(); r++) {
                for (int c = 0; c < slope.get(r).length; c++) {
                    grid[r][c] = slope.get(r)[c];
                }
            }

            Slope adventSlope = new Slope(new AdventGrid<Character>(grid));
            Sled sled = new Sled();

            // Start of sim
            final int dx = 1;
            final int dy = 2;
            while (adventSlope.get(sled.getX() + dx, sled.getY() + dy) != 'N') {
                sled.moveRelative(dx, dy);
                int x = sled.getX();
                int y = sled.getY();
                if (adventSlope.get(x, y) == '#') {
                    adventSlope.set(x, y, 'X');
                    treeCount++;
                } else {
                    adventSlope.set(x, y, 'O');
                }
            }

            adventSlope.printGrid();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println(treeCount);

    }
}