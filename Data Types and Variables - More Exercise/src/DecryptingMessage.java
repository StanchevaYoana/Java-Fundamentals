import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder decryption = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char s = scanner.nextLine().charAt(0);
           int reverse = (int) s + key;
           char symbol = (char) reverse;
           decryption.append(symbol);

        }
        System.out.print(decryption);
    }
}
