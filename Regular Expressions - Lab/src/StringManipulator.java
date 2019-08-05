import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = "";

        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] command = input.split(" ");

            switch (command[0]) {
                case "Add":
                    string += command[1];
                    break;

                case "Print":
                    System.out.println(string);
                    break;

                case "Upgrade":
                    String c = command[1];
                    char toReplace = (char) (command[1].charAt(0) + 1);
                    string = string.replaceAll(c, String.valueOf(toReplace));
                    break;

                case "Index":
                    List<String> indexes = new ArrayList<>();
                    char d = command[1].charAt(0);
                    for (int i = 0; i < string.length(); i++) {
                        if (d == string.charAt(i)) {
                            indexes.add(String.valueOf(i));
                        }
                    }
                    if (indexes.size() > 0) {
                        System.out.println(String.join(" ", indexes));
                    } else {
                        System.out.println("None");
                    }
                    break;
                case "Remove":
                    String stringToRemove = command[1];
                    string = string.replaceAll(stringToRemove, "");
                    break;
            }
        }
    }
}
