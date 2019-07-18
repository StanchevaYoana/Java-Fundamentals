import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int result = sumTwoDigits(a,b) - c;
        System.out.println(result);

    }
    static int sumTwoDigits (int a, int b){
        return a+b;
    }
}
