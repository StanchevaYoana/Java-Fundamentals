import java.util.Arrays;
import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstRow = scanner.nextLine().split(" ");
        String[] secondRow = scanner.nextLine().split(" ");

        for (String n : secondRow) {
            for (String f : firstRow) {
                if (n.equals(f)) {
                    System.out.print(n);
                    System.out.print(" ");
                }
            }
        }
    }
}
