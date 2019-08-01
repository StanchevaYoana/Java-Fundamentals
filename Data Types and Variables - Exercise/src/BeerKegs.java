import java.util.Scanner;

import static java.lang.Math.PI;

public class BeerKegs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String big = "";
        double max = 0;
        for (int i = 1; i <= n; i++) {
            String keg = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int high = Integer.parseInt(scanner.nextLine());
            double pi = (PI * (Math.toDegrees(radius))) * high;
            if (pi > max) {
                big = keg;
                max = pi;
            }
        }
        System.out.println(big);
    }
}
