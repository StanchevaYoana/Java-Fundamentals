import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(vowelsCount(input));
    }

    static int vowelsCount(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            if (a == 'A' || a == 'a' || a == 'E' || a == 'e' || a == 'O' || a == 'o'
                    || a == 'U' || a == 'u' || a == 'I' || a == 'i') {
                count++;
            }
        }
        return count;
    }
}