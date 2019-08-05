import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxPassengers = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] command = input.split(" ");

            if ("Add".equals(command[0])) {
                int passengers = Integer.parseInt(command[1]);
                wagons.add(passengers);

            } else {
                int passengers = Integer.parseInt(command[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    if ((wagons.get(i) + passengers) <= maxPassengers) {
                        wagons.set(i, wagons.get(i) + passengers);
                        break;
                    }
                }
            }

            input = scanner.nextLine();
        }

        System.out.println( print(wagons));

    }

    static String print(List<Integer> wagons) {
        String someStrings = "";
        DecimalFormat print = new DecimalFormat("#.###");
        for (int n : wagons) {
            someStrings += print.format(n) + " ";
        }

        return someStrings.trim();
    }
}