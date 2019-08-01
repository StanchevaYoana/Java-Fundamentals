import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        String operation = scanner.nextLine();
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println(operations(a, operation, b));
    }

    public static int operations(int a, String operation, int b) {
        int result = 0;
        switch (operation) {
            case "*":
                result = a * b;
                break;
            case "-":
                result = a - b;
                break;
            case "+":
                result = a + b;
                break;
            case "/":
                result = a / b;
                break;
        }
        return result;
    }
}

