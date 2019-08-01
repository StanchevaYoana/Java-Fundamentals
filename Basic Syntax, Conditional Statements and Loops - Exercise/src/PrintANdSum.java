import java.util.Scanner;

public class PrintANdSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstDigit = Integer.parseInt(scanner.nextLine());
        int secondDigit = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = firstDigit; i <= secondDigit; i++) {
            sum += i;
            if (i == secondDigit) {
                System.out.print(i);
            } else {
                System.out.print(i + " ");
            }
        }
            System.out.println();
            System.out.printf("Sum: %d",sum);

        }
    }

