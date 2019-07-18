import java.util.Scanner;

public class SpiceMustFlow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long starting = Long.parseLong(scanner.nextLine());
        long days = 0;
        long yielded = 0;
        if (starting < 100) {
            System.out.println(days);
            System.out.println(yielded);
        } else {

            while (starting >= 100) {
                days++;
                yielded += starting;
                starting -= 10;
                yielded -= 26;
            }
            yielded -= 26;

            System.out.println(days);
            System.out.println(yielded);
        }
    }
}


