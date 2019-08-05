import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "\\+359([- ])2\\1[\\d]{3}\\1[\\d]{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> output = new ArrayList<>();

        while (matcher.find()){
            output.add(matcher.group());
        }
        System.out.println(String.join(", ", output));
    }
}
