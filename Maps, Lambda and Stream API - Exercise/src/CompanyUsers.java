import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> firmData = new LinkedHashMap<>();

        String input = "";
        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = input.split(" -> ");
            String company = data[0];
            String user = data[1];

            firmData.putIfAbsent(company, new ArrayList<>());
            if (isUnique(firmData, user, company)) {
                firmData.get(company).add(user);
            }

        }
        firmData.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().stream().forEach(p -> System.out.println(String.format("-- %s", p)));
                });

    }


    static boolean isUnique(Map<String, List<String>> firmData, String user, String company) {
        boolean isUnique = true;
        if (firmData.get(company).size() > 0) {
            for (String s : firmData.get(company)) {
                if (user.equals(s)) {
                    isUnique = false;
                }
            }
        }
        return isUnique;
    }
}