import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstRow = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] secondRow = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        int index = -1;

        for (int i = 0; i < firstRow.length; i++) {

            if (firstRow[i] != secondRow[i]) {
                index = i;
                break;
            }
            sum += firstRow[i];
        }
        if (index == -1) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.print("Arrays are not identical. Found difference at " + index + " index.");
        }
    }
}