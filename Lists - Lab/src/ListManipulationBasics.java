import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] command = input.split(" ");

            if ("Add".equals(command[0])) {
                numbers.add(Integer.parseInt(command[1]));

            } else if ("Remove".equals(command[0])) {
                int digit = Integer.parseInt(command[1]);
                int index = numbers.indexOf(digit);
                numbers.remove(index);

            } else if ("RemoveAt".equals(command[0])) {
                numbers.remove(Integer.parseInt(command[1]));

            } else if ("Insert".equals(command[0])) {

                numbers.add((Integer.parseInt(command[2])), (Integer.parseInt(command[1])));
            }
            input = scanner.nextLine();
        }
        System.out.println(print(numbers));
    }

    static String print(List<Integer> numbers) {
        String string = "";
        DecimalFormat print = new DecimalFormat("#.###");
        for (int a : numbers) {
            string += print.format(a) + " ";
        }
        return string;
    }
}
