import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double floatingPrecision = 0.000001;

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double diff = Math.abs(a - b);

        if (diff > floatingPrecision) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
