import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        List<String> input = new ArrayList<>();
        for (int i = 0; i < input1.length(); i++) {
            char symbol = input1.charAt(i);
            input.add(String.valueOf(symbol));
        }
        int bomb = 0;

        for (int i = 0; i < input.size(); i++) {
            if (bomb > 0 && !input.get(i).equals(">")) {
                input.remove(i);
                i--;
                bomb--;
            } else if (input.get(i).equals(">")) {
                bomb += Integer.parseInt(input.get(i + 1));
            }

        }
        for (var i : input) {
            System.out.print(i);

        }
    }
}