import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> attacked = new TreeMap<>();
        Map<String, Integer> destroyed = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String input = scanner.nextLine();
            int countLetter = 0;
            for (int i = 0; i < input.length(); i++) {
                char symbol = input.toLowerCase().charAt(i);
                if (symbol == 's' || symbol == 't' || symbol == 'a' || symbol == 'r') {
                    countLetter++;
                }
            }

            StringBuilder message = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);
                int number = (int) symbol - countLetter;
                symbol = (char) number;
                message.append(symbol);
            }

            String regex = "@(?<planet>[A-Za-z]+)(?:[^@\\-!:>]*)[:]+(?<population>[\\d]+)(?:[^@\\-!:>]*)[!]+(?<attacked>[A|D]+)[!]+(?:[^@\\-!:>]*)[->]+(?<soldiers>[\\d]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(message);

            while (matcher.find()) {

                if (matcher.group("attacked").equals("A")) {
                    attacked.put(matcher.group("planet"), Integer.parseInt(matcher.group("population")));
                } else if (matcher.group("attacked").equals("D")) {
                    destroyed.put(matcher.group("planet"), Integer.parseInt(matcher.group("population")));
                }
            }
        }

        System.out.println(String.format("Attacked planets: %d", attacked.size()));
        for (Map.Entry<String, Integer> kvp : attacked.entrySet()) {
            System.out.println(String.format("-> %s", kvp.getKey()));
        }
        System.out.println(String.format("Destroyed planets: %d", destroyed.size()));
        for (Map.Entry<String, Integer> kvp : destroyed.entrySet()) {
            System.out.println(String.format("-> %s", kvp.getKey()));
        }
    }
}
