import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrays = new int[3];
        arrays[0] = Integer.parseInt(scanner.nextLine());
        arrays[1] = Integer.parseInt(scanner.nextLine());
        arrays[2] = Integer.parseInt(scanner.nextLine());

        Arrays.sort(arrays);
        for (int i = arrays.length - 1; i >=0 ; i--) {
            System.out.println(arrays[i]);
        }
    }
}

