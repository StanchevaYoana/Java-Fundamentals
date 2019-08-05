import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] numbers = new int[array.length];
        int EqualNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }

        for (int index = 0; index < numbers.length; index++) {

            int firstelement = numbers[index];
            for (int i = index + 1; i < numbers.length; i++) {

                if (firstelement + numbers[i] == EqualNumber) {
                    System.out.println(firstelement + " " + numbers[i]);
                }
            }
        }
    }
}