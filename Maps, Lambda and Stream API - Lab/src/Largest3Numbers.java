import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted((a, b) -> Integer.compare(b, a)).limit(3).collect(Collectors.toList());

        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}