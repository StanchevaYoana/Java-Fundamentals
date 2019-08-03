import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = String.join("",
                scanner.nextLine().split("\\s+"));
        Map<Character, Integer> someMap = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            someMap.putIfAbsent(c, 0);
            someMap.put(c, someMap.get(c) + 1);
        }


        String pattern = "%s -> %d%n";
        for (Map.Entry<Character, Integer> symbol : someMap.entrySet()) {

            System.out.printf(pattern, symbol.getKey(), symbol.getValue());

        }

    }
}