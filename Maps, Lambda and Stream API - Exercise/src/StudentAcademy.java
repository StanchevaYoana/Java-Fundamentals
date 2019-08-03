import javafx.util.Pair;

import java.util.*;

public class StudentAcademy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentData = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            studentData.putIfAbsent(name, new ArrayList<>());
            studentData.get(name).add(grade);

        }
        studentData.entrySet().stream()
                .map(e -> { //change the elements from Map.Entry<String, List<Double>> to Pair<String, Double>
                    Double averageGrade = e.getValue().stream().mapToDouble(x -> x).average().getAsDouble();
                    return new Pair<>(e.getKey(), averageGrade);
                }).filter(e -> e.getValue() >= 4.5) //remove all elements, which do NOT meet this criteria
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) //sort descending
                .forEach(e -> System.out.println(String.format("%s -> %.2f", e.getKey(), e.getValue()))); //print
    }

}
