import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double high = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        int area = (int) areaOfTriangle(high, width);
        System.out.println(area);
    }

    static double areaOfTriangle(double high, double width) {
        return high*width;
    }
}