import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        StringBuilder newPass = new StringBuilder(" ");

        for (int i = n.length() - 1; i >= n.charAt(0); i--) {
            char symbol = n.charAt(i);
            newPass.append(symbol);
        }
        System.out.println(newPass);
    }
}
