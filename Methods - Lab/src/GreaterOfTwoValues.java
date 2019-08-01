import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if ("int".equals(input)) {
            int a = Integer.parseInt(scanner.nextLine());
            int b = Integer.parseInt(scanner.nextLine());
            System.out.println(maxValue(a, b));
        } else if ("string".equals(input)) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            System.out.println(maxValue(a, b));
        } else {
            char a = scanner.nextLine().charAt(0);
            char b = scanner.nextLine().charAt(0);
            System.out.println(maxValue(a, b));
        }
    }

    public static char maxValue(char a, char b) {

        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    public static String maxValue(String a, String b) {

        if (a.compareTo(b) >= 0) {
            return a;
        } else {
            return b;
        }
    }

    public static int maxValue(int a, int b) {

        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }
}