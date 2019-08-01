import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] command = input.split(" ");

            if ("Contains".equals(command[0])) {
                int digit = Integer.parseInt(command[1]);
                int index = numbers.indexOf(digit);
                if (numbers.contains(digit)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }


            } else if ("Print".equals(command[0])) {
                List<Integer> evenList = new ArrayList<>();
                List<Integer> oddList = new ArrayList<>();

                for (int i : numbers) {
                    if (i % 2 == 0) {
                        evenList.add(i);
                    } else {
                        oddList.add(i);
                    }
                }
                if ("even".equals(command[1])) {
                    System.out.println(print(evenList));
                }
                if ("odd".equals(command[1])) {
                    System.out.println(print(oddList));
                }

            } else if ("Get".equals(command[0])) {
                int sum = 0;
                for (int a : numbers) {
                    sum += a;
                }
                System.out.println(sum);

            } else if ("Filter".equals(command[0])) {
                String condition = command[1];
                int num = Integer.parseInt(command[2]);

                List<Integer> filter = new ArrayList<>();

                for (int a : numbers) {
                    switch (condition) {
                        case "<":
                            if (a < num) {
                                filter.add(a);
                            }
                            break;
                        case ">":
                            if (a > num) {
                                filter.add(a);
                            }
                            break;
                        case ">=":
                            if (a >= num) {
                                filter.add(a);
                            }
                            break;
                        case "<=":
                            if (a <= num) {
                                filter.add(a);
                            }
                            break;
                    }
                }
                System.out.println(print(filter));
            }
            input = scanner.nextLine();
        }
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

