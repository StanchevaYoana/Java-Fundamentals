import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCommands = Integer.parseInt(scanner.nextLine());
        List<String> listOfGuests = new ArrayList<>();
        for (int i = 0; i < numCommands; i++) {
            String input = scanner.nextLine();
            String[] command = input.split(" ");
            String name = command[0];
            if ("going!".equals(command[2])) {
                if (listOfGuests.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    listOfGuests.add(name);
                }
            }
            if ("not".equals(command[2])) {
                if (listOfGuests.contains(name)) {
                    listOfGuests.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }

        for (String name : listOfGuests) {
            System.out.println(name.trim());
        }
    }
}
