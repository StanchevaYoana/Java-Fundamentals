import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataTypeFinder {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!"END".equals(input = read.readLine())) {

            if (checkInteger(input)) {
                System.out.println(input + " is integer type");
            } else if (checkDouble(input)) {
                System.out.println(input + " is floating point type");
            } else if (input.length() == 1) {
                System.out.println(input + " is character type");
            } else if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                System.out.println(input + " is boolean type");
            } else {
                System.out.println(input + " is string type");
            }
        }
    }

    private static boolean checkDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean checkInteger(String input) {

        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}