package OrderByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static void print(List<OrderByAge> orderByAgeList) {
        for (OrderByAge order : orderByAgeList) {
            System.out.println(order.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<OrderByAge> orderByAgeList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] data = input.split("\\s+");

            OrderByAge orderByAge = new OrderByAge(data[0], data[1], Integer.parseInt(data[2]));
            orderByAgeList.add(orderByAge);
            input = scanner.nextLine();
        }

        orderByAgeList = orderByAgeList.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .collect(Collectors.toList());

        print(orderByAgeList);


    }

}
