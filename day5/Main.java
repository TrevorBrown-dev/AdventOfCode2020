import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static int toBinary(String s) {
        return Integer.parseInt(s, 2);
    }

    public static int getSeatID(int row, int col) {
        return (row * 8) + col;
    }

    public static String[] partition(String s, int split) {
        String[] rc = { s.substring(0, split), s.substring(split) };
        return rc;
    }

    public static String translateBinary(String s, char zero, char one) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == zero) {
                sb.append("0");
            } else if (c == one) {
                sb.append("1");
            }
        }

        return sb.toString();

    }

    public static int calcSeatID(String input) {
        String[] rc = partition(input, 7);
        rc[0] = translateBinary(rc[0], 'F', 'B');
        rc[1] = translateBinary(rc[1], 'L', 'R');
        int row = toBinary(rc[0]);
        int col = toBinary(rc[1]);
        return getSeatID(row, col);
    }

    public static void main(String[] args) {
        ArrayList<Integer> seatID = new ArrayList<>();
        ArrayList<String> seatCode = new ArrayList<>();
        Scanner scan = null;
        try {
            File f = new File("in.txt");
            scan = new Scanner(f);

            while (scan.hasNextLine()) {
                seatCode.add(scan.nextLine());
            }

            for (String code : seatCode) {
                seatID.add(calcSeatID(code));
            }
            seatID.sort((Integer a, Integer b) -> b - a);
            System.out.println(seatID.get(0));

            for (int i = 0; i < seatID.size() - 1; i++) {
                int seatA = seatID.get(i);
                int seatB = seatID.get(i + 1);
                if ((seatA - seatB) > 1) {
                    System.out.printf("SEAT A: %d\nSeatB: %d\n\n", seatA, seatB);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        scan.close();
    }
}