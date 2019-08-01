import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            int left = Integer.parseInt(input);
            int right = palindromeNum(input);

            if (left == right) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
            input = scanner.nextLine();
        }
    }

    static int palindromeNum(String input) {

        StringBuilder rightSTR = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            rightSTR.append(input.charAt(i));
        }
        int right = Integer.parseInt(rightSTR.toString());
        return right;
    }
}
