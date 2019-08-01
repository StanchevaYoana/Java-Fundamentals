import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int initialSize = numbers.size() / 2;

        for (int i = 0; i < initialSize; i++) {
            int firstNum = numbers.get(i);
            int index = (numbers.size() - 1);
            int nextNum = numbers.get(index);
            int sum = firstNum + nextNum;
            numbers.set(i, sum);
            numbers.remove(index);
        }
        System.out.println(printList(numbers));
    }

    static String printList(List<Integer> numbers) {
        String someString = "";
        DecimalFormat print = new DecimalFormat("#.###");
        for (int a : numbers) {
            someString += print.format(a) + " ";

        }
        return someString.trim();
    }
}