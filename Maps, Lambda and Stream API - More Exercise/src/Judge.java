import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> judge = new LinkedHashMap<>();

        String input;

        while (!"no more time".equals(input = scanner.nextLine())) {
            String[] data = input.split(" -> ");

            String user = data[0];
            String content = data[1];
            int score = Integer.valueOf(data[2]);

            judge.putIfAbsent(content, new LinkedHashMap<>());
            judge.get(content).putIfAbsent(user, score);
            if (judge.get(content).get(user) < score) {
                judge.get(content).put(user, score);
            }
        }

        Map<String, Integer> participantsInfo;

        for (Map.Entry<String, Map<String, Integer>> print : judge.entrySet()) {
            System.out.println(String.format("%s: %d participants", print.getKey(), print.getValue().values().size()));

            AtomicInteger i = new AtomicInteger();
            participantsInfo = print.getValue()
                    .entrySet()
                    .stream()
                    .sorted((a, b) -> {
                        int sort = Integer.compare(b.getValue(), a.getValue());
                        if (sort == 0) {
                            sort = a.getKey().compareTo(b.getKey());
                        }
                        return sort;
                    }).collect(Collectors
                            .toMap(Map.Entry::getKey, Map.Entry::getValue, (c, d) -> c, LinkedHashMap::new));
            for (Map.Entry<String, Integer> innerLoop : participantsInfo.entrySet()) {
                System.out.printf("%d. %s <::> %d%n", i.get() + 1, innerLoop.getKey(), innerLoop.getValue());
                i.getAndIncrement();
            }
        }

        System.out.println("Individual standings:");

        Map<String, Integer> individualStandings = new HashMap<>();
        for (Map.Entry<String, Map<String, Integer>> kvp : judge.entrySet()) {
            for (Map.Entry<String, Integer> kvp2 : kvp.getValue().entrySet()) {

                String user = kvp2.getKey();
                int score = kvp2.getValue();
                individualStandings.putIfAbsent(user, 0);
                individualStandings.put(user, individualStandings.get(user) + score);
            }
        }

        AtomicInteger i = new AtomicInteger();
        individualStandings.entrySet().stream()
                .sorted((a, b) -> {
                    int sort = Integer.compare(b.getValue(), a.getValue());
                    if (sort == 0) {
                        sort = a.getKey().compareTo(b.getKey());
                    }
                    return sort;
                }).forEach(e -> {
            System.out.printf("%d. %s -> %d%n", i.get() + 1, e.getKey(), e.getValue());
            i.getAndIncrement();
        });
    }
}