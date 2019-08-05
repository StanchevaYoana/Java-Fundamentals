import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.length; i++) {
            int count = 0;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    count++;
                    if (count == (numbers.length - 1) - i) {
                        System.out.print(numbers[i] + " ");
                    }
                } else {
                    break;
                }
            }
        }
        System.out.print(numbers[numbers.length - 1]);
    }
}
