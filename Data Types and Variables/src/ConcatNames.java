import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        String delimiter = scanner.nextLine();
        String format = "%s%s%s";

        System.out.printf(format, a,delimiter,b);
    }
}
