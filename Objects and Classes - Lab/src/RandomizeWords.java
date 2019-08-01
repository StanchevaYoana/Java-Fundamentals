import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] words = scanner.nextLine().split("\\s+");
        Random random = new Random(words.length);

        for (int i = 0; i < words.length ; i++) {
            int firstIndex = random.nextInt(words.length);
            int secondIndex = random.nextInt(words.length);

            String firstWord = words[firstIndex];
            String secondWord = words[secondIndex];
            words [firstIndex] = secondWord;
            words [secondIndex] = firstWord;
        }

        for (String word:words) {
            System.out.println(word);

        }
    }
}
