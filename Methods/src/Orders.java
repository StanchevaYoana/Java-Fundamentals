import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String purchase = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        calculationTotalPrice(purchase, count);
    }

    static void calculationTotalPrice(String name, int count) {
        double result = 0;

        switch (name) {
            case "coffee":
                result = count * 1.50;
                break;
            case "coke":
                result = count * 1.40;
                break;
            case "water":
                result = count * 1.00;
                break;
            case "snacks":
                result = count * 2.00;
                break;
        }
        System.out.printf("%.2f", result);
    }
}

