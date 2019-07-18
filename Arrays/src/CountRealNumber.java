import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Map<Integer, Integer> someMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums [i];
            if (!someMap.containsKey(num)) {
                someMap.put(num, 1);
            } else {
                someMap.put(num,( someMap.get(num) + 1));
            }
        }
        someMap.forEach((key, value) -> System.out.println(String.format("%d -> %d", key, value)));
    }
}
