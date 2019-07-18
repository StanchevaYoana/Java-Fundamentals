import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num; i++) {
            int sum = 0;
            int number = i;
            while (i > 0) {
                sum += i % 10;
                i = i / 10;
            }
            boolean isSpecialNum = false;
            isSpecialNum= (sum == 5) || (sum == 7) || (sum == 11);
            if (isSpecialNum) {
                System.out.printf("%d -> True%n", number);
            } else {
                System.out.printf("%d -> False%n", number);
            }
            sum = 0;
            i = number;
        }
    }
}
