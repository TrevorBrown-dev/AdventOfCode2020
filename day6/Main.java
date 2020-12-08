import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static int uniqueCharacters(String s) {
        Hashtable<Character, Integer> table = new Hashtable<>();
        s = s.replaceAll("\n", "");
        char[] chars = s.toCharArray();
        for (char c : chars) {
            table.putIfAbsent(c, 0);
            table.replace(c, table.get(c) + 1);
        }
        return table.size();
    }

    public static int allCharacters(String s) {
        String[] strings = s.trim().split("\n");
        ArrayList<String> set = new ArrayList<>(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));

        for (String string : strings) {
            set.retainAll(Arrays.asList(string.split("")));
        }
        return set.size();
    }

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new File("in.txt"));
            ArrayList<String> quiz = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            String line = "";
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                if (line.equals("")) {
                    quiz.add(sb.toString());
                    sb = new StringBuilder();

                }
                sb.append(line + '\n');
            }
            sb.append(line);
            quiz.add(line);
            scan.close();
            int sum = 0;

            allCharacters(quiz.get(0));
            for (String string : quiz) {
                sum += allCharacters(string);
            }
            System.out.println(sum);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}