import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < a.length(); i++) {
            char n = a.charAt(i);
            sum += n - 48;

        }
        System.out.println(sum);
    }
}
