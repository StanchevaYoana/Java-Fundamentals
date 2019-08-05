import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> first = Arrays.stream(scanner.nextLine().split(" +"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> second = Arrays.stream(scanner.nextLine().split(" +"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> finalList = new ArrayList<>();
        List<Integer> lastNums = new ArrayList<>();
        int length = 0;

        if (first.size() < second.size()) {
            length = first.size();

        } else {
            length = second.size();
        }

        for (int i = 0; i < length; i++) {
            finalList.add(first.get(i));
            finalList.add(second.get((second.size() - 1) - i));
        }

        if (first.size() > second.size()) {
            lastNums.add(first.get(first.size() - 1));
            lastNums.add(first.get(first.size() - 2));
        } else {
            lastNums.add(second.get(0));
            lastNums.add(second.get(1));
        }

        int smallNum = Math.min(lastNums.get(0), lastNums.get(1));
        int bigNum = Math.max(lastNums.get(0), lastNums.get(1));

        finalList.stream().filter(e -> e > smallNum && e < bigNum).sorted(Integer::compare).forEach(e -> System.out.print(e + " "));
    }
}



