import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pass = scanner.nextLine();
        int characters = pass.length();
        if (characters > 5 && characters <= 10 && isValidDigits(pass) > 1 && isHaveOthers(pass) == 0) {
            System.out.println("Password is valid");
        }
        if (characters < 6) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (isHaveOthers(pass) > 0) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (isValidDigits(pass) < 1) {
            System.out.println("Password must have at least 2 digits");
        }
    }

    static int isValidDigits(String pass) {
        int digits = 0;
        for (int i = 0; i < pass.length(); i++) {
            int n = pass.charAt(i);
            if (n != 45) {
                if (n > 47 && n < 58) {
                    digits++;
                }
            } else {
                continue;
            }
        }
        return digits;
    }

    static int isHaveOthers(String pass) {
        int other = 0;
        for (int i = 0; i < pass.length(); i++) {
            int n = pass.charAt(i);
            if (n < 48 || (n > 57 && n < 65) || (n > 90 && n < 97) || n > 122) {
                other++;
            }
        }
        return other;
    }
}