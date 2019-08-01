import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        if (n > 1) {
            isTopNum(n);
        }
    }

    static void isTopNum(int n) {

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            boolean isOdd = false;
            int index = i;

            while (true) {
                if (index == 0) break;
                int right = index % 10;
                sum += right;
                if (!(right % 2 == 0)) isOdd = true;
                index /= 10;
            }
            if (sum % 8 == 0 && isOdd) {
                System.out.println(i);
            }
        }
    }
}
