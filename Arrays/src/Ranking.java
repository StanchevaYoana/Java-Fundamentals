import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, String> listOfData = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> lastData = new TreeMap<>();
        String input;

        while (!"end of contests".equals(input = scanner.nextLine())) {

            String[] data = input.split(":");
            listOfData.putIfAbsent(data[0], null);
            listOfData.put(data[0], data[1]);

        }

        while (!"end of submissions".equals(input = scanner.nextLine())) {
            String[] data = input.split("=>");
            String course = data[0];
            String pass = data[1];
            String name = data[2];
            int score = Integer.valueOf(data[3]);

            if (listOfData.containsKey(course)) {
                if (listOfData.containsValue(pass)) {
                    lastData.putIfAbsent(name, new LinkedHashMap<>());
                    lastData.get(name).putIfAbsent(course, 0);
                    if (lastData.get(name).get(course) < score) {
                        lastData.get(name).put(course, score);
                    }

                }
            }

        }


        int maxScore = Integer.MIN_VALUE;
        String bestStudent = "";

        for (Entry<String, Map<String, Integer>> kvp : lastData.entrySet()) {
            int sum = 0;
            String name = kvp.getKey();

            for (Entry<String, Integer> entry : kvp.getValue().entrySet()) {
                sum += entry.getValue();
            }
            if (sum > maxScore) {
                maxScore = sum;
                bestStudent = name;
            }
        }


        System.out.println(String.format("Best candidate is %s with total %d points.%nRanking: "
                , bestStudent, maxScore));

        lastData = lastData
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, b1) -> a1, LinkedHashMap::new));

        for (Map.Entry<String, Map<String, Integer>> print : lastData.entrySet()) {
            System.out.println(print.getKey());

            print.getValue()
                    .entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue())).forEach(e -> {
                System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue());
            });

        }

    }
}

