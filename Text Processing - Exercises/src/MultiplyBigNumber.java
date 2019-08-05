import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bigNum = scanner.nextLine().replaceFirst("^0+(?!$)", "");
        int multipleNum = Integer.parseInt(scanner.nextLine());
        StringBuilder finalNum = new StringBuilder();

        int decimalReminder = 0;
        if (bigNum.isEmpty()){
            bigNum = "0";
        }
        if (multipleNum == 0) {
            System.out.println(0);
            return;
        }

        for (int i = bigNum.length() - 1; i >= 0; i--) {
            int num = (int) bigNum.charAt(i) - 48;
            int currentSum = num * multipleNum;
            currentSum += decimalReminder;
            finalNum.append(currentSum % 10);
            decimalReminder = currentSum / 10;
        }

        if (decimalReminder > 0) {
            finalNum.append(decimalReminder);
        }

        System.out.println(finalNum.reverse());
    }
}