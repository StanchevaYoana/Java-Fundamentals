import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();
        StringBuilder output = new StringBuilder();

        Pattern patternDigit = Pattern.compile("\\d+");
        Matcher matcherDigit = patternDigit.matcher(input);
        Pattern patternSymbol = Pattern.compile("[^\\d]+");
        Matcher matcherSymbol = patternSymbol.matcher(input);

        while (matcherDigit.find() && matcherSymbol.find()) {
            String sequence = matcherSymbol.group();
            int repeat = Integer.parseInt(matcherDigit.group());
            for (int i = 0; i < repeat; i++) {
                output.append(sequence);
            }
        }

        Set<String> uniqueSet = new HashSet<>();
        for (int i = 0; i < output.length(); i++) {
            uniqueSet.add(String.valueOf(output.charAt(i)));
        }
        System.out.printf("Unique symbols used: %d\n", uniqueSet.size());
        System.out.println(output);
    }
}
