package Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudent = Integer.parseInt(scanner.nextLine());
        List<Students> students = new ArrayList<>();

        while (numberOfStudent-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            Students students1 = new Students(data[0], data[1], Double.parseDouble(data[2]));
            students.add(students1);

        }

        students = students.stream()
                .sorted((p1, p2) -> Double.compare(p2.getGrade(), p1.getGrade()))
                .collect(Collectors.toList());

        for (Students student : students) {
            System.out.println(student.toString());

        }


    }


}
