import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        matrix(n);
    }

    static void matrix(int n) {

        for (int i = 0; i < n; i++) {
            System.out.print(n + " ");
            for (int k = 1; k < n; k++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
