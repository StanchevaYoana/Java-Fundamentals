import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> copyDrumSet = new ArrayList<>(drumSet);

        String input = scanner.nextLine();

        while (!"Hit it again, Gabsy!".equals(input)) {
            int hitPower = Integer.parseInt(input);

            for (int i = 0; i < drumSet.size(); i++) {
                drumSet.set(i, drumSet.get(i) - hitPower);
                if (drumSet.get(i) <= 0) {
                    int value = copyDrumSet.get(i) * 3;
                    if (budget >= value) {
                        budget -= value;
                        drumSet.set(i, copyDrumSet.get(i));
                    } else {
                        drumSet.remove(i);
                        copyDrumSet.remove(i);
                        if (i == 0 || i == drumSet.size() - 1) {
                            i--;
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }

        System.out.println(drumSet.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", budget);
    }
}
