import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> dataOfMiner = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"stop".equals(input)) {

            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            dataOfMiner.putIfAbsent(resource, 0);
            dataOfMiner.put(resource, dataOfMiner.get(resource) + quantity);

            input = scanner.nextLine();
        }

        String pattern = "%s -> %d%n";
        for (Map.Entry<String, Integer> resources : dataOfMiner.entrySet()) {

            System.out.printf(pattern, resources.getKey(), resources.getValue());

        }

    }
}
