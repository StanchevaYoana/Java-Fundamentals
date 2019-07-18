import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine()
                .split(", ")).collect(Collectors.toList());
        Map<String, Integer> dataRacers = new LinkedHashMap<>();

        for (String i : list ) dataRacers.put(i,0);

        String input;
        while (!"end of race".equals(input = scanner.nextLine())) {
            String regex = "(?<digit>\\d)|(?<char>[A-Za-z])";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            StringBuilder racerName = new StringBuilder();
            int distance = 0;

            StringBuilder matchedInput = new StringBuilder();

            while (matcher.find()) {
                matchedInput.append(matcher.group());
            }

            for (int i = 0; i < matchedInput.length(); i++) {
                char symbol = matchedInput.charAt(i);
                if (Character.isDigit(symbol)) {
                    int number = (int) symbol - 48;
                    distance += number;
                } else if (Character.isAlphabetic(symbol)) {
                    racerName.append(symbol);
                }
            }

            if (dataRacers.containsKey(String.valueOf(racerName))) {
                int oldValue = dataRacers.get(String.valueOf(racerName));
                dataRacers.put(String.valueOf(racerName), oldValue + distance);
            }
        }

        dataRacers = dataRacers.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (c, d) -> c, LinkedHashMap::new));

        int count = 1;

        for (Map.Entry<String, Integer> name : dataRacers.entrySet()) {
            if (count == 1) {
                System.out.println("1st place: " + name.getKey());
            } else if (count == 2) {
                System.out.println("2nd place: " + name.getKey());
            } else {
                System.out.println("3rd place: " + name.getKey());
            }
            count++;
        }

    }
}
