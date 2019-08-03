import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> priceAndProduct = new LinkedHashMap<>();
        Map<String, Integer> quantityAndProduct = new LinkedHashMap<>();

        String input = "";
        int count = 0;

        while (!"buy".equals(input = scanner.nextLine())) {
            String[] pd = input.split("\\s+");
            String name = pd[0];
            double price = Double.parseDouble(pd[1]);
            int quantity = Integer.parseInt(pd[2]);

            priceAndProduct.putIfAbsent(name, price);
            priceAndProduct.put(name, price);
            quantityAndProduct.putIfAbsent(name, 0);
            quantityAndProduct.put(name, quantityAndProduct.get(name) + quantity);

            count++;

        }

        Map<String, Double> finalData = new LinkedHashMap<>();
        for (Map.Entry<String, Double> w : priceAndProduct.entrySet()) {

            String name = w.getKey();
            int quantity = quantityAndProduct.get(name);
            double price = w.getValue();
            double totalPrice = price * quantity;

            finalData.put(name, totalPrice);

        }
        finalData.entrySet().stream().forEach(e -> {
            System.out.println(String.format("%s -> %.2f", e.getKey(), e.getValue()));
        });

    }
}
