import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] nameOfEmoji = scanner.nextLine().split(":");
        StringBuilder matchedName = new StringBuilder(":");
        for (String s : nameOfEmoji) {
            int number = Integer.parseInt(s);
            matchedName.append((char) number);
        }
        matchedName.append(':');

        String regex = "(?<=[,]|[ ]|[!]|[?])(?<name>:[a-z]{4,}:)(?=[,]|[ ]|[.]|[!]|[?])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int sum = 0;
        List<String> emojiFound = new ArrayList<>();
        boolean match = false;

        while (matcher.find()) {
            String name = matcher.group("name");
            if (name.contentEquals(matchedName)) {
                match = true;
            }
            emojiFound.add(matcher.group("name"));

            for (int i = 1; i < name.length()-1; i++) {
                char symbol = name.charAt(i);
                sum += (int) symbol;
            }
        }
        if (emojiFound.size() > 0) {
            System.out.print("Emojis found: ");
            System.out.print(String.join(", ", emojiFound));
        }
        if (match) {
            sum *= 2;
        }
        System.out.println();
        System.out.println(String.format("Total Emoji Power: %d", sum));
    }
}
