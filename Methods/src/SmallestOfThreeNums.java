import java.util.Scanner;

public class SmallestOfThreeNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(minDigit(nums));
    }

    static int minDigit(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}

