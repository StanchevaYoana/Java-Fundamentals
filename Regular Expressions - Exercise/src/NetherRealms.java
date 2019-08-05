import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[,\\s\\t\\n]+");

        String inRegex = "^([^, ]+)$";
        Pattern pattern = Pattern.compile(inRegex);
        Map<String, Map<Integer, Double>> demons = new TreeMap<>();

        for (String currentDemon : input) {
            Matcher match = pattern.matcher(currentDemon);

            if (match.find()) {
                demons.putIfAbsent(currentDemon, new LinkedHashMap<>());

                Pattern healthPattern = Pattern.compile("[^0-9.*\\-\\+\\/]");
                Pattern damagePattern = Pattern.compile("([-|+]?[\\d.]+)");
                Matcher healthMatcher = healthPattern.matcher(currentDemon);
                Matcher damageMatcher = damagePattern.matcher(currentDemon);

                int totalHealth = 0;
                while (healthMatcher.find()) {
                    char c = healthMatcher.group().charAt(0);
                    totalHealth += c;
                }

                double damage = 0;
                while (damageMatcher.find()) {
                    damage += Double.parseDouble(damageMatcher.group());
                }

                for (int i = 0; i < currentDemon.length(); i++) {
                    if (currentDemon.charAt(i) == '/') {
                        damage /= 2;
                    } else if (currentDemon.charAt(i) == '*') {
                        damage *= 2;
                    }
                }
                demons.get(currentDemon).put(totalHealth, damage);
            }
        }
        demons.forEach((key, value) ->
                value.forEach((key1, value1) ->
                        System.out.println(String.format("%s - %d health, %.2f damage", key, key1, value1))));
    }
}