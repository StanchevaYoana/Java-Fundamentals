import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String abc = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        System.out.println(newString(abc,count));

    }
    static String newString (String name, int count){
        return String.valueOf(name).repeat(Math.max(0, count));
    }
}
