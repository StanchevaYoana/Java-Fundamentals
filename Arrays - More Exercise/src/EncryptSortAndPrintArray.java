import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] sumNames = new int[n];

        boolean vowel = false;

        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int sum = 0;
            for (int j = 0; j < input.length(); j++) {
                char symbol = input.charAt(j);
                for (char c : vowels) {
                    if (symbol != c) {
                        continue;
                    } else {
                        int digit = (int) symbol * input.length();
                        sum += digit;
                        vowel = true;
                        break;
                    }
                }
                if (vowel) {
                    vowel = false;
                    continue;
                } else {
                    int digit = (int) symbol / input.length();
                    sum += digit;
                }
            }
            sumNames[i] = sum;
        }
        Arrays.sort(sumNames);
        for (int a : sumNames) {
            System.out.println(a);
        }
    }
}