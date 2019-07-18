import java.util.*;
import java.util.stream.Collectors;

public class SoftUniKaraoke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] singers = scanner.nextLine().split(", ");
        List<String> songs = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        Map<String, List<String>> data = new HashMap<>();

        for (String singer : singers) {
            data.putIfAbsent(singer, new ArrayList<>());
        }

        String input;

        while (!"dawn".equals(input = scanner.nextLine())) {

            String[] singerSongAward = input.split(", ");
            String singer = singerSongAward[0];
            String song = singerSongAward[1];
            String award = singerSongAward[2];

            if (data.containsKey(singer) && songs.contains(song)) {
                if (!data.get(singer).contains(award)) {
                    data.get(singer).add(award);
                }
            }

        }
        if (haveAwards(data)) {

            data =  data.entrySet().stream().filter(e -> e.getValue().size() > 0).sorted((a, b) -> {

                int sort = Integer.compare(b.getValue().size(), a.getValue().size());
                if (sort == 0) {
                    sort = a.getKey().compareTo(b.getKey());
                }
                return sort;
            }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> a, LinkedHashMap::new));


            for (Map.Entry<String, List<String>> keyValuePair : data.entrySet()) {
                System.out.println(String.format("%s: %d awards", keyValuePair.getKey(), keyValuePair.getValue().size()));

                List<String> sortedList = keyValuePair.getValue().stream().sorted(String::compareTo).collect(Collectors.toList()); // Тук става сортирането на вътрешните листове.
                for (String s : sortedList) {
                    System.out.println(String.format("--%s", s));
                }
            }
        } else {
            System.out.println("No awards");

        }
    }

    static boolean haveAwards(Map<String, List<String>> data) {

        for (Map.Entry<String, List<String>> g : data.entrySet()) {
            if (g.getValue().size() > 0) {
                return true;
            }
        }
        return false;
    }
}