import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> finalList = new ArrayList<>();
        int index = 0;

        if (firstList.size() < secondList.size()) {
            index = firstList.size();
        } else {
            index = secondList.size();
        }

        int loopIndex = 0;

        for (int i = 0; i <= index - 1; i++) {
            finalList.add(loopIndex, firstList.get(i));
            finalList.add(loopIndex + 1, secondList.get(i));
            firstList.remove(i);
            secondList.remove(i);
            i = -1;
            loopIndex += 2;
            index--;
        }
        if (!firstList.isEmpty()) {
            finalList.addAll(firstList);
        }
        if (!secondList.isEmpty()) {
            finalList.addAll(secondList);

        }
        System.out.println(print(finalList));
    }

    static String print(List<Integer> finalList) {
        StringBuilder list = new StringBuilder();

        DecimalFormat print = new DecimalFormat("#.###");
        for (int n : finalList) {
            list.append(print.format(n)).append(" ");
        }
        return list.toString().trim();
    }
}


