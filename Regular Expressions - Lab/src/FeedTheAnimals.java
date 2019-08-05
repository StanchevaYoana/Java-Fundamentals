import java.util.*;

public class FeedTheAnimals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> animalFood = new LinkedHashMap<>();
        Map<String, List<String>> areaAnimals = new LinkedHashMap<>();

        String input;
        while (!"Last Info".equals(input = scanner.nextLine())) {
            String[] command = input.split(":");
            switch (command[0]) {
                case "Add":
                    if (animalFood.containsKey(command[1])) {
                        int newValue = animalFood.get(command[1]) + Integer.parseInt(command[2]);
                        animalFood.put(command[1], newValue);
                    } else {
                        animalFood.put(command[1], Integer.parseInt(command[2]));
                        areaAnimals.putIfAbsent(command[3], new ArrayList<>());
                        areaAnimals.get(command[3]).add(command[1]);
                    }
                    break;

                case "Feed":
                    if (animalFood.containsKey(command[1])) {
                        animalFood.put(command[1], animalFood.get(command[1]) - Integer.parseInt(command[2]));
                        if (animalFood.get(command[1]) <= 0) {
                            System.out.println(String.format("%s was successfully fed", command[1]));
                            animalFood.remove(command[1]);
                            areaAnimals.get(command[3]).remove(command[1]);
                        }
                    }
                    break;
            }
        }
        System.out.println("Animals:");
        animalFood.entrySet().stream().sorted((a, b) -> {
            int sort = b.getValue().compareTo(a.getValue());
            if (sort == 0) {
                sort = a.getKey().compareTo(b.getKey());
            }
            return sort;
        }).forEach(e -> {
            System.out.println(String.format("%s -> %dg", e.getKey(), e.getValue()));
        });

        System.out.println("Areas with hungry animals:");

        areaAnimals.entrySet().stream().filter(e -> e.getValue().size() > 0).sorted((a, b) -> {
            return Integer.compare(b.getValue().size(), a.getValue().size());
        }).forEach(e -> {
            System.out.println(String.format("%s : %d", e.getKey(), e.getValue().size()));
        });
    }
}