import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Map<String, Integer> data = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            String key = input[i].toLowerCase();
            data.putIfAbsent(key, 0);
            data.put(key, data.get(key) + 1);
        }

        List<String> synonyms = new ArrayList<>();
        for (Map.Entry<String, Integer> kvp : data.entrySet()) {

            int countValue = kvp.getValue();
            if (countValue % 2 != 0) {
                synonyms.add(kvp.getKey());
            }
        }

        System.out.print(String.join(", ", synonyms));
    }
}
