
import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pokePowerN = Integer.parseInt(scanner.nextLine());
        int distanceM = Integer.parseInt(scanner.nextLine());
        int exhaustionFactorY = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int halfPower = pokePowerN / 2;


        while (pokePowerN >= distanceM) {
            pokePowerN -= distanceM;
            count++;
            if (pokePowerN == halfPower && exhaustionFactorY > 0) {
                pokePowerN /= exhaustionFactorY;
            }
        }
        System.out.println(pokePowerN);
        System.out.println(count);
    }
}
