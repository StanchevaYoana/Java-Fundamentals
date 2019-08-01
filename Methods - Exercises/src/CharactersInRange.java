import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char a = scanner.nextLine().charAt(0);
        char b = scanner.nextLine().charAt(0);
        System.out.println(charactersInRange(a, b));
    }

    static String charactersInRange(char a, char b) {
        StringBuilder range = new StringBuilder();
        if ((int) a < (int) b) {
            for (int i = a + 1; i < b; i++) {
                char r = (char) i;
                range.append(r).append(" ");
            }
        } else {
            for (int i = b + 1; i < a; i++) {
                char r = (char) i;

                range.append(r).append(" ");
            }
        }
        return range.toString();
    }
}
