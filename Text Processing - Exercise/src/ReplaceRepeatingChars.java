import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        StringBuilder finalText = new StringBuilder();
        char previous = ' ';
        for (int i = 0; i <input.length() ; i++) {
            char symbol = input.charAt(i);
            if ( symbol != previous){
                finalText.append(symbol);
                previous = symbol;
            }

        }
        System.out.println(finalText);
    }
}