import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int factorial = Integer.parseInt(scanner.nextLine());
        BigInteger sum = BigInteger.valueOf(1);
        for (int i = 1; i <= factorial; i++) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        System.out.println(sum);
    }
}
