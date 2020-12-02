import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int findNum(ArrayList<Integer> list) {
        int comparisons = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > 0; j--) {
                if (list.get(i) + list.get(j) == 2020) {
                    System.out.println(comparisons);
                    return list.get(i) * list.get(j);

                }
                comparisons++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = null;
        try {
            File f = new File(args[0]);
            scan = new Scanner(f);
            ArrayList<Integer> list = new ArrayList<Integer>();
            while (scan.hasNextInt())
                list.add(scan.nextInt());

            list.sort((a, b) -> a - b);
            System.out.println(findNum(list));
        } catch (Exception e) {
            // TODO: handle exception
        }

        scan.close();
    }
}