import java.util.Arrays;
import java.util.Scanner;

public class EnglishNameLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int f = n % 10;

        switch (f) {
            case 9:
                System.out.println("nine");
                break;
            case 8:
                System.out.println("eight");
                break;
            case 7:
                System.out.println("seven");
                break;
            case 6:
                System.out.println("six");
                break;
            case 5:
                System.out.println("five");
                break;
            case 4:
                System.out.println("four");
                break;
            case 3:
                System.out.println("three");
                break;
            case 2:
                System.out.println("two");
                break;
            case 1:
                System.out.println("one");
                break;
            case 0:
                System.out.println("zero");
        }
    }
}