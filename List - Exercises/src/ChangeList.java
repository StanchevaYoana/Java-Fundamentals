import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Arrays.stream(read.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String input;

        while (!"end".equals(input = read.readLine())) {
            String[] data = input.split("\\s+");
            if ("Delete".equals(data[0])) {
                int num = Integer.parseInt(data[1]);

                while (nums.contains(num)) {
                    nums.remove(Integer.valueOf(num));
                }
            } else {
                int element = Integer.parseInt(data[1]);
                int index = Integer.parseInt(data[2]);
                if (index >= 0 && index < nums.size()) {
                    nums.add(index, element);
                }
            }
        }
        System.out.println(nums.toString().replaceAll("[\\[\\],]", ""));
    }
}