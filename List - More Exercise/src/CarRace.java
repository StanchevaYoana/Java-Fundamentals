import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> race = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int finishIndex = race.size() / 2;
        double leftRacer = 0;
        double rightRacer = 0;


        for (int i = 0; i < finishIndex; i++) {
            if (race.get(i) == 0) {
                leftRacer *= 0.80;
            }
            leftRacer += race.get(i);

        }
        for (int i = race.size() - 1; i > finishIndex; i--) {
            if (race.get(i) == 0) {
                rightRacer *= 0.80;
            }
            rightRacer += race.get(i);
        }

        if (leftRacer < rightRacer) {
            System.out.printf("The winner is left with total time: %.1f", leftRacer);
        } else {
            System.out.printf("The winner is right with total time: %.1f", rightRacer);
        }
    }
}
