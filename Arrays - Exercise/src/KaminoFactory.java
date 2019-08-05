import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KaminoFactory {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int elements = Integer.parseInt(read.readLine());

        String bestDna = "";
        int bestLength = 0;
        int bestSum = 0;
        int bestIndex = 0;
        int bestSample = 0;
        int counter = 0;
        String oneSequence = "";

        while (true) {
            counter++;
            String input = read.readLine();
            if (input.equals("Clone them!")) {
                break;
            }

            int maxLength = 0;
            int sum = 0;

            String sequence = input.replaceAll("!", "");
            String[] ones = sequence.split("0+");

            for (int i = 0; i < ones.length; i++) {

                if (ones[i].length() > maxLength) {

                    maxLength = ones[i].length();
                    oneSequence = ones[i];

                }
                sum += ones[i].length();

            }
            int leftmostOne = sequence.indexOf(oneSequence);

            if (maxLength > bestLength) {

                bestLength = maxLength;
                bestDna = sequence;
                bestIndex = leftmostOne;
                bestSum = sum;
                bestSample = counter;
            } else if (maxLength == bestLength && (leftmostOne < bestIndex || sum > bestSum)) {

                bestLength = maxLength;
                bestDna = sequence;
                bestIndex = leftmostOne;
                bestSum = sum;
                bestSample = counter;

            } else if (counter == 1) {

                bestLength = maxLength;
                bestSum = sum;
                bestDna = sequence;
                bestIndex = leftmostOne;
                bestSample = counter;
            }
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSample, bestSum);

        String[] result = bestDna.split("");

        System.out.println(String.join(" ", result));
    }
}
