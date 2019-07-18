import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long maxVolume = 0;
        int maxSnowBallSnow = 0;
        int maxSnowBallTime = 0;
        int maxSnowBallQuality=0;


        for (int i = 0; i < n ; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            int divide = snowballSnow / snowballTime;

            long snowballValue = (long) Math.pow(divide, snowballQuality);
            if (snowballValue >= maxVolume) {
                maxSnowBallQuality = snowballQuality;
                maxSnowBallSnow = snowballSnow;
                maxSnowBallTime = snowballTime;
                maxVolume = snowballValue;
            }
        }
            String format = "%d : %d = %d (%d)";
            System.out.printf(format, maxSnowBallSnow, maxSnowBallTime, maxVolume, maxSnowBallQuality);

        }
    }


