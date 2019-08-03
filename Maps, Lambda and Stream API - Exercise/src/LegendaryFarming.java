import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> keyMaterials = new HashMap<>();
        Map<String, Integer> trash = new HashMap<>();
        String winner = "";
        boolean haveWinner = false;

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        do {
            String[] input = scanner.nextLine().split("\\s+");

            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.valueOf(input[i]);
                String material = input[i + 1].toLowerCase();

                if (!keyMaterials.containsKey(material)) {
                    trash.putIfAbsent(material, 0);
                    trash.put(material, trash.get(material) + quantity);

                } else {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        switch (material) {
                            case "shards":
                                winner = "Shadowmourne";
                                break;
                            case "fragments":
                                winner = "Valanyr";
                                break;
                            case "motes":
                                winner = "Dragonwrath";
                                break;
                        }
                        System.out.printf("%s obtained!%n", winner);
                        haveWinner = true;
                        break;
                    }
                }
            }
        } while (!haveWinner);

        keyMaterials
                .entrySet().stream().sorted((a, b) -> {
            int sort = Integer.compare(b.getValue(), a.getValue());
            if (sort == 0) {
                sort = a.getKey().compareTo(b.getKey());
            }
            return sort;
        }).forEach(e -> {
            System.out.println(String.format(
                    "%s: %d", e.getKey(), e.getValue()
            ));
        });

        trash
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> {
                    System.out.println(String.format("%s: %d", e.getKey(), e.getValue()));
                });
    }
}
