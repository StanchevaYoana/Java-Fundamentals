import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        for (int i = 0; i < firstPlayer.size(); i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            } else {
                if (firstPlayer.get(i) > secondPlayer.get(i)) {
                    firstPlayer.add(firstPlayer.get(i));
                    firstPlayer.add(secondPlayer.get(i));
                    secondPlayer.remove(i);
                    firstPlayer.remove(i);
                    i--;
                } else if (secondPlayer.get(i).equals(firstPlayer.get(i))) {
                    secondPlayer.remove(i);
                    firstPlayer.remove(i);
                    i--;
                } else {
                    secondPlayer.add(secondPlayer.get(i));
                    secondPlayer.add(firstPlayer.get(i));
                    firstPlayer.remove(i);
                    secondPlayer.remove(i);
                    i--;
                }
            }
        }


        int sum = 0;
        if (firstPlayer.size() > 0) {
            for (int n : firstPlayer) {
                sum += n;
            }
            System.out.printf("First player wins! Sum: %d", sum);

        } else if (secondPlayer.size() > 0) {
            for (int n : secondPlayer) {
                sum += n;
            }
            System.out.printf("Second player wins! Sum: %d", sum);

        }
    }
}

