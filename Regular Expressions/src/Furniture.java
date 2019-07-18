import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = 0;

        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>\\d+|([\\d]+.[\\d]+))!(?<quantity>\\d+)";

        Pattern pattern = Pattern.compile(regex);
        List<String> boughtFurniture = new ArrayList<>();
        String input;

        while (!"Purchase".equals(input = scanner.nextLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                sum += price * quantity;
                boughtFurniture.add(matcher.group("furniture"));
            }
        }

        System.out.println("Bought furniture:");
        boughtFurniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f\n", sum);
    }
}
