import java.util.*;

public class SoftUniExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> languages = new HashMap<>();
        Map<String, Integer> students = new HashMap<>();

        String input;

        while (!"exam finished".equals(input = scanner.nextLine())) {

            String[] command = input.split("-");

            String name = command[0];
            String course = command[1];

            if (!course.equals("banned")) {
                int result = Integer.parseInt(command[2]);
                if (!languages.containsKey(course)) {
                    languages.put(course, 1);
                } else {
                    languages.put(course, languages.get(course) + 1);
                }
                if (!students.containsKey(name)) {
                    students.put(name, result);
                } else {
                    int oldValue = students.get(name);
                    if (oldValue < result) {
                        students.put(name, result);
                    }
                }

            } else {
                students.remove(name);
            }
        }
        System.out.println("Results:");

        students.entrySet().stream().sorted((a, b) -> {
            int sort = Integer.compare(b.getValue(), a.getValue());
            if (sort == 0) {
                sort = a.getKey().compareTo(b.getKey());
            }
            return sort;
        }).forEach(e -> {
            System.out.println(String.format("%s | %d", e.getKey(), e.getValue()));
        });

        System.out.println("Submissions:");
        languages.entrySet().stream().sorted((a, b) ->
        {
            int sort = Integer.compare(b.getValue(), a.getValue());
            if (sort == 0) {
                sort = a.getKey().compareTo(b.getKey());
            }
            return sort;

        }).forEach(entry -> {
            System.out.println(String.format("%s - %d", entry.getKey(), entry.getValue()));
        });
    }
}

