import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main
 */
public class Main {
    public static boolean isBetween(int min, int max, int num) {
        return !(num < min || num > max);

    }

    public static void main(String[] args) {

        try {
            File f = new File("in.txt");
            Scanner scan = new Scanner(f);
            StringBuilder sb = new StringBuilder();
            ArrayList<String> passport = new ArrayList<>();
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                if (s.equals("")) {
                    // System.out.println("BLANK");
                    passport.add(sb.toString());
                    sb = new StringBuilder();
                }

                sb.append(s + " ");
            }
            passport.add(sb.toString());

            int validPassports = 0;

            String[] fields = { "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid" };

            for (String p : passport) {
                boolean valid = true;
                String[] field = p.split(" ");
                for (int i = 0; i < field.length; i++) {
                    System.out.println(field[i]);
                    String[] token = field[i].split(":");
                    switch (token[0]) {
                        case "byr":
                            if (!isBetween(1920, 2002, Integer.parseInt(token[1])))
                                valid = false;
                            if (!valid)
                                System.out.println("INVALID BYR");
                            break;
                        case "iyr":
                            if (!isBetween(2010, 2020, Integer.parseInt(token[1])))
                                valid = false;
                            if (!valid)
                                System.out.println("INVALID IYR");
                            break;
                        case "eyr":
                            if (!isBetween(2020, 2030, Integer.parseInt(token[1])))
                                valid = false;
                            if (!valid)
                                System.out.println("INVALID EYR");
                            break;
                        case "hgt":
                            int height;
                            if (token[1].contains("cm")) {
                                height = Integer.parseInt(token[1].substring(0, token[1].length() - 2));
                                if (!isBetween(150, 193, height))
                                    valid = false;
                            } else if (token[1].contains("in")) {
                                height = Integer.parseInt(token[1].substring(0, token[1].length() - 2));
                                if (!isBetween(59, 76, height))
                                    valid = false;
                            } else {
                                valid = false;
                            }

                            if (!valid)
                                System.out.println("INVALID HGT");
                            break;
                        case "hcl":
                            if (token[1].matches("\\#[a-f0-9]{6}") == false)
                                valid = false;
                            if (!valid)
                                System.out.println("INVALID HCL");
                            break;
                        case "ecl":
                            String[] validColors = { "amb", "blu", "brn", "gry", "grn", "hzl", "oth" };
                            boolean validColor = false;
                            for (String col : validColors) {
                                if (token[1].equals(col))
                                    validColor = true;
                            }
                            if (validColor == false)
                                valid = false;

                            if (!valid)
                                System.out.println("INVALID ECL");
                            break;
                        case "pid":
                            boolean validPid = token[1].length() == 9;
                            if (!validPid)
                                valid = false;
                            if (!valid)
                                System.out.println("INVALID PID");
                            System.out.println(token[1]);
                            break;

                    }
                    // if (!valid)
                    // break;
                }

                for (String fl : fields) {
                    if (!p.contains(fl + ":"))
                        valid = false;
                }

                if (valid)
                    validPassports++;
                else {
                    System.out.println("INVALID");
                }

            }
            System.out.println(validPassports);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}