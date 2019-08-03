import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> stringMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String key = scanner.nextLine();
            String value = scanner.nextLine();
            stringMap.putIfAbsent(key, new ArrayList<>());
            stringMap.get(key).add(value);
        }

        String pattern = "%s - %s%n";
        for (Map.Entry<String, List<String>> kvp : stringMap.entrySet()) {

            String keyFinal = kvp.getKey();
            String synonyms = String.join(", ", kvp.getValue());

            System.out.printf(pattern, keyFinal, synonyms);
        }
    }
}