import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Snowwhite {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> dwarfs = new LinkedHashMap<>();
        String string;

        while (!"Once upon a time".equals(string = scanner.nextLine())) {
            String[] input = string.split(" <:> ");

            String name = input[0];
            String hatColour = input[1];
            int physics = Integer.parseInt(input[2]);

            dwarfs.putIfAbsent(hatColour, new LinkedHashMap<>());
            dwarfs.get(hatColour).putIfAbsent(name, 0);
            int oldValue = dwarfs.get(hatColour).get(name);
            if (oldValue < physics) {
                dwarfs.get(hatColour).put(name, physics);
            }
        }

        if (dwarfs.entrySet().size() > 1) {

            dwarfs = dwarfs.entrySet().stream().sorted((a, b) -> {
                int sortA = 0;
                int sortB = 0;
                for (Map.Entry<String, Integer> innerMap : a.getValue().entrySet()) {
                    sortA = innerMap.getValue();
                }
                for (Map.Entry<String, Integer> innerMap : b.getValue().entrySet()) {
                    sortB = innerMap.getValue();
                }
                int sort = Integer.compare(sortB, sortA);
                if (sort == 0) {
                    sort = a.getKey().compareTo(b.getKey());
                }
                return sort;

            }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (c, d) -> c, LinkedHashMap::new));
        }

        dwarfs.entrySet().forEach((e -> {
            e.getValue().forEach((key, value) -> System.out.println(String.format("(%s) %s <-> %d", e.getKey(), key, value)));
        }));
    }
}
