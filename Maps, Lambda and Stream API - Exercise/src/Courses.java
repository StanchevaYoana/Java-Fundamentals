import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, List<String>> data = new LinkedHashMap<>();

        while (!"end".equals(input = scanner.nextLine())) {
            String[] commands = input.split(":");

            String courseName = commands[0];
            String studentName = commands[1];

            data.putIfAbsent(courseName, new ArrayList<>());
            data.get(courseName).add(studentName);
        }

        data.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue().size(), (a.getValue().size())))
                .forEach(e -> {
                    System.out.println(String.format("%s: %s", e.getKey().trim(), e.getValue().size()));
                    e.getValue().stream().sorted((a, b) -> a.compareTo(b)).forEach(w ->
                            System.out.println(String.format("-- %s", w.trim())));

                });

    }
}
