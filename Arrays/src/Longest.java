import java.util.Arrays;
import java.util.Scanner;

public class Longest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (numbers.length == 1) {
            System.out.println(numbers[0]);
        } else {

            int min = Integer.MAX_VALUE;
            int indexMin = 0;
            int count = 0;

            for (int i = 0; i < numbers.length; i++) {

                if (numbers[i] < min) {
                    min = numbers[i];
                    indexMin = i;
                } else {
                    continue;
                }
            }

            int[] subsequents = new int[numbers.length];
            subsequents[indexMin] = min;
            for (int i = indexMin + 1; i < numbers.length; i++) {
                if (numbers[i] > subsequents[indexMin]) {
                    subsequents[i] = numbers[i];
                    count++;

                    if (numbers[i] < subsequents[i - 1]) {
                        subsequents[i] = numbers[i];
                        count++;
                    }

                    System.out.println(subsequents[indexMin]);
                } else {
                    break;
                }
            }

        }

    }
}
