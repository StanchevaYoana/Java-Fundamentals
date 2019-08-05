import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] fibonachi = new int[n];
        if (n <= 1) {
            System.out.println(n);
            return;
        } else {
            fibonachi[0] = 1;
            fibonachi[1] = 1;
        }

        for (int i = 2; i < n; i++) {
            fibonachi[i] = fibonachi[i - 1] + fibonachi[i - 2];
        }
        System.out.println(fibonachi[fibonachi.length - 1]);
    }
}