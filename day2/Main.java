import java.io.File;
import java.util.Scanner;

public class Main {
    public static boolean checkPassword(String password, int min, int max, char c) {
        int count = 0;
        char[] chars = password.toCharArray();
        for (char d : chars) {
            if (d == c)
                count++;
            if (count > max)
                return false;
        }

        return count >= min;
    }

    public static boolean checkPassword2(String password, int a, int b, char c) {
        char[] chars = password.toCharArray();
        return (chars[a - 1] == c ^ chars[b - 1] == c);
    }

    public static void main(String[] args) {
        Scanner scan = null;
        int num = 0;
        try {
            File f = new File(args[0]);
            scan = new Scanner(f);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();

                String[] passArgs = s.split(" ");
                String[] nums = passArgs[0].split("-");
                int min = Integer.parseInt(nums[0]);
                int max = Integer.parseInt(nums[1]);
                char c = passArgs[1].charAt(0);
                String password = passArgs[2];
                if (checkPassword2(password, min, max, c))
                    num++;
            }
            System.out.println(num);
        } catch (Exception e) {
        }
        scan.close();
    }
}