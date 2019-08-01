import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int first = 1;


        for(int i = 1; i <= num; ++i) {
            for(int j = 1; j <= i; ++j) {
                System.out.print(first + " ");
            }
            ++first;

            System.out.println();
        }
    }
}