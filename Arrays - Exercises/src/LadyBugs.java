import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fieldSize = Integer.parseInt(sc.nextLine());
        int[] indexes = Arrays.stream(sc.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt).filter(index -> index >= 0 && index < fieldSize)
                .toArray();

        int[] myField = new int[fieldSize];
        for (int index : indexes) {
            myField[index] = 1;
        }

        String command = sc.nextLine();
        while (!"end".equals(command)) {
            String[] data = command.split("\\s+");
            int ladyBugIndex = Integer.parseInt(data[0]);
            String direction = (data[1]);
            int flyLength = Integer.parseInt(data[2]);

            if (ladyBugIndex >= 0 && ladyBugIndex < myField.length && myField[ladyBugIndex] == 1) {
                myField[ladyBugIndex] = 0;

                while (true) {
                    switch (direction) {
                        case "right":
                            ladyBugIndex += flyLength;
                            break;

                        case "left":
                            ladyBugIndex -= flyLength;
                            break;
                    }

                    if (ladyBugIndex >= myField.length || ladyBugIndex < 0) {
                        break;
                    }
                    if (myField[ladyBugIndex] == 1) {
                        continue;
                    }
                    if (myField[ladyBugIndex] == 0) {
                        myField[ladyBugIndex] = 1;
                        break;
                    }
                }
            }
            command = sc.nextLine();
        }
        for (int i : myField) {
            System.out.print(i + " ");
        }
    }
}