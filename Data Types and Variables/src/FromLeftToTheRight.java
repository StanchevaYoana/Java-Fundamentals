import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            long number = scanner.nextLong();
            long number2 = scanner.nextLong();
            long  max = Math.max(number,number2);
            max = Math.abs(max);

            long sum = String.valueOf(max)
                    .chars()
                    .map(Character::getNumericValue)
                    .sum();

            System.out.println(sum);
        }
    }
}
