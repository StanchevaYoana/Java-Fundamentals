import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double sum = 0;
        while (!"Start".equals(input)) {
            double insert = Double.parseDouble(input);
            if (insert == 0.1 || insert == 0.2 || insert == 0.5 || insert == 1 || insert == 2) {
                sum += insert;
            } else {
                System.out.printf("Cannot accept %.2f%n", insert);
            }
            input = scanner.nextLine();
        }

        double cost = 0;
        input = scanner.nextLine();
        while (!"End".equals(input)) {
            switch (input) {
                case "Nuts":
                    cost = 2.0;
                    break;
                case "Water":
                    cost = 0.7;
                    break;
                case "Crisps":
                    cost = 1.50;
                    break;
                case "Soda":
                    cost = 0.80;
                    break;
                case "Coke":
                    cost = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            if (cost <= sum&& cost!=0) {
                sum -= cost;
                System.out.printf("Purchased %s%n", input);
            } else if (cost > sum){
                System.out.println("Sorry, not enough money");
            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sum);
    }
}