import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int index = 0;
        int max = 0;

        for (int i = 0; i < num.length; i++) {
            int count = 0;
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] == num[j]) {
                    count++;
                    if (max < count) {
                        max = count;
                        index = i;
                    }
                } else {
                    break;
                }
            }
        }
        for (int i = index; i <= index + max; i++) {
            System.out.print(num[i] + " ");
        }
    }
}