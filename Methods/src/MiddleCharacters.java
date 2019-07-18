import java.util.Scanner;

public class MiddleCharacters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println(middleCharacter(input));
    }

    static String middleCharacter(String input) {
        String characters = "";
        if (input.length() % 2 == 0) {
            int result = (input.length()) / 2;
            characters += input.charAt(result - 1);
            characters += input.charAt(result);
        } else {
            characters += input.charAt(input.length() / 2);
        }
        return characters;
    }
}
