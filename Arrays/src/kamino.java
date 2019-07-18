import java.util.Arrays;
import java.util.Scanner;

public class kamino {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        if (n < 1) {
            System.out.println("Best DNA sample 0 with sum: 0.");
        } else {

            String input = scanner.nextLine();
            int maxSequence = Integer.MIN_VALUE;
            int bestIndex = 0;
            int[] bestDNA = new int[n];
            int sum = 0;
            int rowSeq = 1;
            int sample = 1;
            while (!"Clone them!".equals(input)) {

                int[] numbers = Arrays.stream(input.split("!+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                int sequence = 0;
                int index = 0;

                for (int i = 0; i < numbers.length; i++) {
                    for (int j = i+1; j < numbers.length-1; j++) {
                        if (numbers[i] == 1 && numbers[j] == 1) {
                            sequence++;
                            index = i;
                        } else {
                            break;
                        }
                    }
                }
                if (maxSequence < sequence) {
                    maxSequence = sequence;
                    bestIndex = index;
                    for (int i = 0; i < bestDNA.length; i++) {
                        bestDNA[i] = numbers[i];
                    }
                    sum = Arrays.stream(bestDNA).sum();
                    rowSeq = sample;
                } else if (maxSequence == sequence && bestIndex > index) {
                    bestIndex = index;
                    for (int i = 0; i < bestDNA.length; i++) {
                        bestDNA[i] = numbers[i];
                    }
                    rowSeq = sample;
                } else if (maxSequence == sequence && bestIndex == index) {
                    int currentSum = Arrays.stream(bestDNA).sum();
                    if (currentSum > sum) {
                        for (int i = 0; i < bestDNA.length; i++) {
                            bestDNA[i] = numbers[i];
                        }
                        rowSeq = sample;
                    }
                }
                sample++;
                input = scanner.nextLine();
            }
            System.out.printf("Best DNA sample %d with sum: %d.", rowSeq, Arrays.stream(bestDNA).sum());
            System.out.println();

            for (int a : bestDNA) {
                System.out.print(a + " ");
            }
        }
    }
}