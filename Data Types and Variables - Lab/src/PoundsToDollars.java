import java.util.Scanner;

public class PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pounds = Double.parseDouble(scanner.nextLine());

        double usd = pounds*1.31;
        String format = "%.3f";
        System.out.printf(format, usd);
    }
}
