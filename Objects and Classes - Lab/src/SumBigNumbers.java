import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger firstNum = new BigInteger(scanner.next());
        BigInteger secondNum = new BigInteger(scanner.next());

        BigInteger sum = firstNum.add(secondNum);

        System.out.println(sum);
    }
}
