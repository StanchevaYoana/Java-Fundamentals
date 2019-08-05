import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDoNotGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum = 0;
        while (true) {
            if (list.isEmpty()) {
                break;
            }

            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0) {
                int number = list.get(0);
                sum += list.get(0);
                addSubstractValueFromList(list, number);
                list.set(0, list.get(list.size() - 1));

            } else if (index >= list.size()) {
                int number = list.get(list.size() - 1);
                sum += list.get(list.size() - 1);
                addSubstractValueFromList(list, number);
                list.set(list.size() - 1, list.get(0));

            } else {
                int number = list.get(index);
                list.remove(index);
                sum += number;
                addSubstractValueFromList(list, number);
            }
        }
        System.out.println(sum);
    }

    static void addSubstractValueFromList(List<Integer> list, int number) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < number || list.get(i) == number) {
                int value = list.get(i) + number;
                list.set(i, value);
            } else if (list.get(i) > number) {
                int value = list.get(i) - number;
                list.set(i, value);
            }

        }
    }
}
