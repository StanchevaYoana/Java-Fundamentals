import java.util.Scanner;

public class WaterOverflow {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int capacity = 255;
        int in = 0;

        for (int i = 0; i < n; i++) {
            int litres = Integer.parseInt(scanner.nextLine());
            if (litres <= capacity) {
                in += litres;
                capacity -= litres;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }

        System.out.println(in);
    }
}