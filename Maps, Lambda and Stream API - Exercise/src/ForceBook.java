import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, List<String>> sides = new TreeMap<>();
        String input = scan.nextLine();
        while (!input.equals("Lumpawaroo")) {
            String[] data = input.split(Pattern.quote(" -> "));
            if (data.length == 2) {
                String force = data[1];
                String name = data[0];
                if (sides.entrySet().stream().filter(i -> i.getValue().contains(name)).collect(Collectors.toList()).size() == 0) {
                    sides = regNewUser(name, force, sides);
                    System.out.printf("%s joins the %s side!%n", name, force);
                } else {
                    sides.entrySet().stream().forEach(i -> {
                        if (i.getValue().contains(name)) {
                            i.getValue().remove(name);
                        }
                    });
                    sides = regNewUser(name, force, sides);
                    System.out.printf("%s joins the %s side!%n", name, force);
                }
            } else {
                data = input.split(Pattern.quote(" | "));
                String force = data[0];
                String name = data[1];
                if (sides.entrySet().stream().filter(i -> i.getValue().contains(name)).collect(Collectors.toList()).size() == 0) {
                    sides = regNewUser(name, force, sides);
                }
            }
            input = scan.nextLine();
        }
        sides.entrySet().stream().filter(i -> i.getValue().size() > 0).sorted((o1, o2) -> Integer.compare(o2.getValue().size(), o1.getValue().size()))
                .forEach(e -> {
                    System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                    e.getValue().stream().sorted(Comparator.naturalOrder()).forEach(p -> System.out.printf("! %s%n", p));
                });
    }

    public static TreeMap<String, List<String>> regNewUser(String name, String force, TreeMap<String, List<String>> sides) {
        if (!sides.containsKey(force)) {
            sides.put(force, new ArrayList<>());
        }
        sides.get(force).add(name);
        return sides;
    }
}