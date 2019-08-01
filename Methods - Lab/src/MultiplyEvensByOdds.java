import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        System.out.println(sum(numbers));
    }

    public static int sum(String numbers) {
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < numbers.length(); i++) {
            if ((numbers.charAt(i)) != 45) {
                int n = (numbers.charAt(i) - 48);
                if (n % 2 == 0) {
                    evenSum += n;
                } else {
                    oddSum += (n);
                }
            }
        }
        int result = evenSum * oddSum;
        return result;
    }
}




