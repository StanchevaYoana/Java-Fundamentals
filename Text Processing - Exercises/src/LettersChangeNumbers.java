import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        double sum = 0;

        for (String string : strings) {
            double number = Double.parseDouble(string.substring(1, string.length() - 1));
            if (number == 0) {
                System.out.println(0);
                return;
            }

            char firstLetter = string.charAt(0);
            int firstLetterPosition = FindLetterPosition(firstLetter);
            if (isUpper(firstLetter)) {
                number /= firstLetterPosition;

            } else {
                number *= firstLetterPosition;
            }

            char lastLetter = string.charAt(string.length() - 1);
            int lastStringPosition = FindLetterPosition(lastLetter);
            if (isUpper(lastLetter)) {
                number -= lastStringPosition;
            } else {
                number += lastStringPosition;
            }

            sum += number;
        }
        System.out.println(String.format("%.2f", sum));
    }


    private static boolean isUpper(char letter) {
        boolean isUpper = letter >= 65 && letter <= 90;
        return isUpper;
    }

    private static int FindLetterPosition(char letter) {
        boolean isUpper = letter >= 65 && letter <= 90;
        int letterPositionAlfabet = 0;

        if (isUpper) {
            return letterPositionAlfabet = letter - 65 + 1;
        } else {
            return letterPositionAlfabet = letter - 97 + 1;
        }
    }
}