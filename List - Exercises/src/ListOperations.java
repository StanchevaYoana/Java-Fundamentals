import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] command = input.split(" +");
            if ("Add".equals(command[0])) {
                int num = Integer.parseInt(command[1]);
                numbers.add(num);

            } else if ("Insert".equals(command[0])) {
                int num = Integer.parseInt(command[1]);
                int index = Integer.parseInt(command[2]);
                if (index < 0 || index >= numbers.size()) {
                    System.out.println("Invalid index");
                } else {
                    numbers.add(index, num);
                }

            } else if ("Remove".equals(command[0])) {
                int index = Integer.parseInt(command[1]);
                if (index < 0 || index >= numbers.size()) {
                    System.out.println("Invalid index");
                } else {
                    numbers.remove(index);
                }

            } else if ("Shift".equals(command[0])) {
                int shift = Integer.parseInt(command[2]);

                if ("left".equals(command[1])) {

                    for (int i = 0; i < shift; i++) {
                        numbers.add(numbers.get(0));
                        numbers.remove(0);
                    }

                } else {
                    for (int i = 0; i < shift; i++) {
                        int index = numbers.size();
                        numbers.add(0, numbers.get(index - 1));
                        numbers.remove(index);

                    }
                }
            }

            input = scanner.nextLine();
        }
        System.out.println(print(numbers));
    }

    static String print(List<Integer> numbers) {
        StringBuilder someNums = new StringBuilder();
        DecimalFormat print = new DecimalFormat("#.###");
        for (int a : numbers) {
            someNums.append(print.format(a)).append(" ");
        }
        return someNums.toString().trim();
    }
}
