import java.util.Scanner;

public class ZigZag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] firsArray = new String[n];
        String[] secondRow = new String[n];

        for (int i = 0; i < n; i++) {
            String[] row = scanner.nextLine().split(" ");
            if (i % 2 == 0) {
                firsArray[i] = row[0];
                secondRow[i] = row[1];
            } else {
                secondRow[i] = row[0];
                firsArray[i] = row[1];
            }
        }
        for (String f :
                firsArray) {
            System.out.print(f + " ");
        }
        System.out.println();
        for (String s : secondRow
        ) {
            System.out.print(s + " ");

        }
    }
}
