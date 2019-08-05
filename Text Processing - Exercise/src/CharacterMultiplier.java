import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder first = new StringBuilder(scanner.next());
        StringBuilder second = new StringBuilder(scanner.next());

        int result = 0;
        int min = Math.min(first.length(), second.length());

        for (int i = 0; i < min; i++) {
            char f = first.charAt(i);
            char s = second.charAt(i);
            result += f * s;
        }
        if (first.length() != second.length()) {
            int max = Math.max(first.length(), second.length());
            StringBuilder longer;
            if (first.length() > second.length()) {
                longer = first;
            } else {
                longer = second;
            }
            for (int i = min; i < max; i++) {
                result += longer.charAt(i);
            }
        }

        System.out.println(result);
    }
}