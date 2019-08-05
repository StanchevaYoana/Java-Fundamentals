import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        for (String pass : input) {
            if (pass.length() <= 16 && pass.length() >= 3) {
                if (isValid(pass)) {
                    System.out.println(pass);
                }
            }
        }
    }

    static boolean isValid(String pass) {

        for (int i = 0; i < pass.length(); i++) {
            char symbol = pass.charAt(i);

            if (Character.isAlphabetic(symbol) || Character.isDigit(symbol) || symbol == '-' || symbol == '_') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}