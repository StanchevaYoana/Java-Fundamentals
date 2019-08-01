import java.util.Scanner;

public class ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        for (int j = input.length - 1; j >= 0; j--) {

            System.out.print(input[j] + " ");
        }
    }
}