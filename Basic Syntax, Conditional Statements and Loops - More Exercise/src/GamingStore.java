import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double ballance = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        double cost = 0;

        while (!"Game Time".equals(input)) {
            if ("OutFall 4".equals(input) || "CS: OG".equals(input) || "Zplinter Zell".equals(input)
            ||"Honored 2".equals(input) || "RoverWatch".equals(input) || "RoverWatch Origins Edition".equals(input)) {
                double priceGame = 0;
                if (ballance == 0) {
                    break;
                }
                switch (input) {
                    case "OutFall 4":
                        priceGame = 39.99;
                        break;
                    case "CS: OG":
                        priceGame = 15.99;
                        break;
                    case "Zplinter Zell":
                        priceGame = 19.99;
                        break;
                    case "Honored 2":
                        priceGame = 59.99;
                        break;
                    case "RoverWatch":
                        priceGame = 29.99;
                        break;
                    case "RoverWatch Origins Edition":
                        priceGame = 39.99;
                        break;
                    default:
                        System.out.println("Not Found");
                        break;
                }
                if (priceGame > ballance) {
                    System.out.println("Too Expensive");
                }
                if (priceGame <= ballance) {
                    ballance -= priceGame;
                    cost += priceGame;
                    System.out.printf("Bought %s%n", input);
                }
                input = scanner.nextLine();
            } else {
                System.out.println("Not Found");
                input = scanner.nextLine();
            }
        }
        if (ballance == 0) {
            System.out.println("Out of money!");
        } else {
            System.out.printf("Total spent: $%.2f.", cost);
            System.out.print(" ");
            System.out.printf("Remaining: $%.2f", ballance);
        }
    }
}