import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";

        Pattern pattern = Pattern.compile(regex);
        StringBuilder matchedStrings = new StringBuilder();
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            matchedStrings.append(matcher.group() + " ");
        }

        matchedStrings.trimToSize();
        System.out.print(matchedStrings);
    }
}