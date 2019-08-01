import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(read.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String[] data = read.readLine().split("\\s+");

        int bombNumber = Integer.parseInt(data[0]);
        int sizeOfBomb = Integer.parseInt(data[1]);

        while (numbers.contains(bombNumber)) {
            int elementIndex = numbers.indexOf(bombNumber);

            int left = Math.max(0, elementIndex - sizeOfBomb);
            int right = Math.min(elementIndex + sizeOfBomb, numbers.size() - 1);

            if (right >= left) {
                numbers.subList(left, right + 1).clear();
            }
        }
        System.out.println(numbers.stream().mapToInt(Integer::intValue).sum());
    }
}