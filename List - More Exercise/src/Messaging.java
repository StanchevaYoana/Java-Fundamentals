import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String letters = scanner.nextLine();
        List<Character> charList = new ArrayList<Character>();
        for (int i = 0; i < letters.length(); i++) {
            charList.add(letters.charAt(i));
        }

        StringBuilder output = new StringBuilder();

        for (Integer number : numbers) {
            String digits = Integer.toString(number);
            int sum = 0;
            for (int j = 0; j < digits.length(); j++) {
                sum += digits.charAt(j) - '0';
            }

            while (true) {
                if (sum < charList.size() && sum >= 0) {
                    break;
                } else
                    sum -= charList.size();
            }

            output.append(charList.get(sum));
            charList.remove(sum);
        }
        System.out.println(output);
    }
}

