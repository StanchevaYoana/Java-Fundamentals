import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!"course start".equals(input)) {

            String[] command = input.split(":");
            switch (command[0]) {
                case "Add":
                    if (list.contains(command[1])) {
                        break;
                    } else {
                        list.add(command[1]);
                    }

                    break;

                case "Insert":
                    if (list.contains(command[1])) {
                        break;
                    } else {
                        int index = Integer.parseInt(command[2]);
                        list.add(index, command[1]);
                    }
                    break;
                case "Remove":
                    list.remove(command[1]);
                    break;

                case "Swap":
                    String exercise = command[1] + "-Exercise";
                    String exercise2 = command[2] + "-Exercise";
                    if (list.contains(command[1]) && list.contains(command[2])
                            && list.contains(exercise) && list.contains(exercise2)) {
                        int firstIndex = list.indexOf(command[1]);
                        int secondIndex = list.indexOf(command[2]);
                        String holder = list.get(firstIndex);
                        String holder2 = list.get(firstIndex + 1);
                        list.set(firstIndex, command[2]);
                        list.set(firstIndex + 1, exercise2);
                        list.set(secondIndex, holder);
                        list.set(secondIndex + 1, holder2);
                    } else if (list.contains(command[1]) && list.contains(exercise) && list.contains(command[2])) {
                        int firstIndex = list.indexOf(command[1]);
                        int secondIndex = list.indexOf(command[2]);


                        String holder = list.get(firstIndex);
                        String holder2 = list.get(firstIndex + 1);
                        list.set(firstIndex, command[2]);
                        list.set(secondIndex, holder);

                        if (secondIndex == list.size() - 1) {
                            list.add(holder2);
                        } else {
                            list.add(secondIndex + 1, holder2);
                        }
                        list.remove(firstIndex + 1);
                    } else if (list.contains(command[1]) && list.contains(exercise2) && list.contains(command[2])) {
                        int firstIndex = list.indexOf(command[1]);
                        int secondIndex = list.indexOf(command[2]);
                        String holder = list.get(firstIndex);
                        list.set(firstIndex, command[2]);
                        list.add(firstIndex + 1, exercise2);
                        list.set(secondIndex + 1, holder);
                        list.remove(secondIndex + 2);
                    } else if (list.contains(command[1]) && list.contains(command[2])) {
                        int firstIndex = list.indexOf(command[1]);
                        int secondIndex = list.indexOf(command[2]);
                        String holder = list.get(firstIndex);
                        list.set(firstIndex, command[2]);
                        list.set(secondIndex, holder);
                    }
                    break;

                case "Exercise":
                    String exercise1 = command[1] + "-Exercise";
                    if (list.contains(command[1])) {
                        int index = list.indexOf(command[1]);

                        if (list.contains(exercise1)) {
                            break;
                        } else {
                            list.add(index + 1, exercise1);
                        }
                    } else {
                        list.add(command[1]);
                        list.add(exercise1);
                    }
            }
            input = scanner.nextLine();
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, list.get(i));
        }
    }
}
