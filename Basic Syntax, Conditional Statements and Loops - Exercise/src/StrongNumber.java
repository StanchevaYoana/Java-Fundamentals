import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        String str = Integer.toString(input);

        int sum2 = 0;

        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            int sum = 1;
            for (int j = 1; j <= digit; j++) {
                sum *= j;
            }
            sum2 += sum;
        }
        if (sum2 == input) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}