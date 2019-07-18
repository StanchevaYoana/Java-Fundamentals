import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();

        int number = Integer.parseInt(n);
        for (int num = 1; num <= number; num++) {
            if (num <= 9) {
                if (num == 5 || num == 7) {
                    System.out.printf("%d -> True%n", num);
                } else {
                    System.out.printf("%d -> False%n", num);
                }
            }

            int sum = 0;
            if (num > 9) {
                sum = (num % 10) + (num / 10);
                if (sum == 5 || sum == 7 || sum == 11) {
                    System.out.printf("%d -> True%n", num);
                } else {
                    System.out.printf("%d -> False%n", num);
                }
            }
        }
    }
}