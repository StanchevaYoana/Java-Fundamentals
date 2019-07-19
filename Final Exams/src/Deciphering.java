import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLineIn = scanner.nextLine();
        String regex = "^[d-z{}|#]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(firstLineIn);

        if (matcher.find()) {
            StringBuilder subscribedString = new StringBuilder();
            for (int i = 0; i < firstLineIn.length(); i++) {
                char symbol = firstLineIn.charAt(i);
                subscribedString.append((char) (symbol - 3));
            }
            String[] secondLineIn = scanner.nextLine().split(" ");

            String replacedString = String.valueOf(subscribedString).replaceAll(secondLineIn[0], secondLineIn[1]);
            System.out.println(replacedString);

        } else {
            System.out.println("This is not the book you are looking for.");
        }
    }
}
