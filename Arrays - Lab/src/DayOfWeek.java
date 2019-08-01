import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] dayOfWeeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        if (n <= 0 || n > dayOfWeeks.length) {
            System.out.print("Invalid day!");
        } else {
            System.out.println(dayOfWeeks[n - 1]);
        }
    }
}