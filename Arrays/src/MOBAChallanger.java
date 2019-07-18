import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MOBAChallanger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Map<String, Map<String, Integer>> players = new LinkedHashMap<>();

        while (!"Season end".equals(input = scanner.nextLine())) {

            String[] command = input.split(" ");
            if (command[1].equals("->")) {

                String[] data = input.split(" -> ");
                String name = data[0];
                String position = data[1];
                int skill = Integer.valueOf(data[2]);

                players.putIfAbsent(name, new LinkedHashMap<>());
                players.get(name).putIfAbsent(position, 0);
                if (players.get(name).get(position) < skill) {
                    players.get(name).put(position, skill);
                }


            } else {
                String player1 = command[0];
                String player2 = command[2];
                int playerOneTotalSkills = 0;
                int playerTwoTotalSkills = 0;
                int count = 0;
                if (players.containsKey(player1) && players.containsKey(player2)) {
                    for (Map.Entry<String, Integer> kvp : players.get(player1).entrySet()) {
                        playerOneTotalSkills += kvp.getValue();
                        for (Map.Entry<String, Integer> kvp2 : players.get(player2).entrySet()) {
                            playerTwoTotalSkills += kvp2.getValue();
                            if (kvp.getKey().equals(kvp2.getKey())) {
                                count++;
                            }
                        }
                    }
                    if (count > 0) {
                        if (playerOneTotalSkills > playerTwoTotalSkills) {
                            players.remove(player2);
                        } else if (playerOneTotalSkills < playerTwoTotalSkills){
                            players.remove(player1);
                        }
                    }
                }
            }
        }

        players = players.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int valueA = 0;
                    int valueB = 0;
                    for (Map.Entry<String, Integer> kvpA : a.getValue().entrySet()) {
                        valueA += kvpA.getValue();
                    }
                    for (Map.Entry<String, Integer> kvpB : b.getValue().entrySet()) {
                        valueB += kvpB.getValue();
                    }
                    int sort = Integer.compare(valueB, valueA);
                    if (sort == 0) {
                        sort = a.getKey().compareTo(b.getKey());
                    }
                    return sort;
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));


        Map<String, Integer> helpMap;

        for (Map.Entry<String, Map<String, Integer>> outerMap : players.entrySet()) {
            int totalSkill = 0;

            helpMap = outerMap.getValue()
                    .entrySet()
                    .stream().sorted((a, b) -> {
                        int sort = Integer.compare(b.getValue(), a.getValue());
                        if (sort == 0) {
                            sort = a.getKey().compareTo(b.getKey());
                        }
                        return sort;
                    }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
            for (Map.Entry<String, Integer> innerMap : helpMap.entrySet()) {
                totalSkill += innerMap.getValue();
            }
            System.out.printf("%s: %d skill%n", outerMap.getKey(), totalSkill);

            for (Map.Entry<String, Integer> innerMap : helpMap.entrySet()) {
                System.out.printf("- %s <::> %d%n", innerMap.getKey(), innerMap.getValue());
            }

        }

    }
}

