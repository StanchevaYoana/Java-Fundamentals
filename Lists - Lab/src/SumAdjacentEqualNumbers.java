import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        List<Double> newArray = new ArrayList<>();

        for (int i = 0; i < numbers.size() - 1; i++) {
            double num = numbers.get(i);
            double num2 = numbers.get(i + 1);
            if (num == num2) {
                double sum = num + num2;
                numbers.set(i, sum);
                numbers.remove(i + 1);
                i = -1;
            }
        }

        System.out.print(printElements(numbers));
    }

    static String printElements(List<Double> list) {

        StringBuilder someString = new StringBuilder();
        DecimalFormat print = new DecimalFormat("#.###");

        for (Double num : list) {
            someString.append(print.format(num)).append(" ");
        }
        return someString.toString().trim();
    }
}



