import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleOfManTTRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^([#$%*&])(?<name>[A-Za-z]+)\\1=(?<length>[\\d]+)!!(?<geohash>(.)*)$";
        Pattern pattern = Pattern.compile(regex);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String geoHash = matcher.group("geoHash");
                int num = Integer.parseInt(matcher.group("length"));
                if (geoHash.length() == num) {
                    StringBuilder code = new StringBuilder();
                    for (int i = 0; i < geoHash.length(); i++) {
                        char char1 = (char) (geoHash.charAt(i) + num);
                        code.append(char1);
                    }
                    System.out.println(String.format("Coordinates found! %s -> %s", matcher.group("name"), code));
                } else {
                    System.out.println("Nothing found!");
                }

            } else {
                System.out.println("Nothing found!");

            }
        }
    }
}
