import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pass = scanner.nextLine();
        String correctPass = "";
        for (int i = pass.length() - 1; i >= 0; i--) {
            char symbol = pass.charAt(i);
            correctPass += symbol;
        }

        for (int i = 0; i < 4; i++) {
            String input = scanner.nextLine();
            if (correctPass.equals(input)) {
                System.out.printf("User %s logged in.%n", pass);
                break;
            } else if ((!correctPass.equals(input)) && (i >= 0) && (i < 3)) {
                System.out.println("Incorrect password. Try again.");
            } else if (!correctPass.equals(input) && i == 3) {
                System.out.printf("User %s blocked!", pass);
            }
        }
    }
}