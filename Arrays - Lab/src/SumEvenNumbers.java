import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] numbersAsString = input.split(" ");
        int[] num = new int[numbersAsString.length];

        for (int i = 0; i < numbersAsString.length; i++) {
            num[i] = Integer.parseInt(numbersAsString[i]);
        }
        int sum = 0;

        for (int value : num) {
            if (value % 2 == 0) {
                sum += value;
            }
        }
        System.out.println(sum);
    }
}
