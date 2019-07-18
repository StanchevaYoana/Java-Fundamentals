import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = (scanner.nextLine().split(" "));
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n % array.length; i++) {
            String holder = array[0];
            System.arraycopy(array, 1, array, 0, array.length - 1);
            array[array.length - 1] = holder;
        }

        for (String a : array) {
            System.out.print(a + " ");
        }
    }
}