import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int meters = Integer.parseInt(scanner.nextLine());

        double km = meters/1000.;
        String format = "%.2f";
        System.out.printf(format,km);

    }
}
