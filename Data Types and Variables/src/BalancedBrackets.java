import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int countOpen = 0;
        int countClose = 0;

        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();
            if ("(".equalsIgnoreCase(input)) {
                countOpen++;
                if (countOpen > 1) {
                    break;
                }
            }
            if (")".equalsIgnoreCase(input)) {
                countClose++;

                if (")".equalsIgnoreCase(input) && countOpen > 0) {
                    countOpen = 0;
                    countClose--;
                }
            }
        }

        if (countClose == 0 && countOpen == 0) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
