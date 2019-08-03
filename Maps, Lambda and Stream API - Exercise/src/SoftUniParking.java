import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> data = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] input = scanner.nextLine().split("\\s+");
            String userName = input[1];
            switch (input[0]) {

                case "register":
                    String licensePlateNumber = input[2];
                    if (data.containsKey(userName)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", data.get(userName));
                    } else {
                        data.putIfAbsent(userName, licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n", userName, licensePlateNumber);
                    }
                    break;

                case "unregister":
                    if (!data.containsKey(userName)) {
                        System.out.printf("ERROR: user %s not found%n", userName);
                    } else {
                        data.remove(userName);
                        System.out.printf("%s unregistered successfully%n", userName);
                    }
                    break;
            }
        }

        data.entrySet().stream().forEach(e -> {
            System.out.println(String.format("%s => %s", e.getKey(), e.getValue()));
        });
    }
}
