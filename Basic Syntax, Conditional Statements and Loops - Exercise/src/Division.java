import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int[] arrays = new int[5];

        if (number % 10 == 0) {
            arrays[0] = 10;
        } else if (number % 7 == 0) {
            arrays[1] = 7;
        } else if (number % 6 == 0) {
            arrays[2] = 6;
        } else if (number % 3 == 0) {
            arrays[3] = 3;
        } else if (number % 2 == 0) {
            arrays[4] = 2;
        }
        boolean isDevisible = true;
        for (int num : arrays) {
            if (num != 0) {
                isDevisible = false;
                System.out.println("The number is divisible by " + num);
                break;
            }
        }
        if (isDevisible) {
            System.out.println("Not divisible");
        }
    }
}