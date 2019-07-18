import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] number = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();

        while (!"end".equals(input)) {

            String[] command = input.split(" ");

            if (command[0].equals("exchange")) {
                int index = Integer.parseInt(command[1]);
                if (index >= 0 && index < number.length) {
                    exchange(number, index);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (command[0].equals("max")) {
                if (command[1].equals("even")) {
                    int index = findEvenIndex(number);
                    if (index != -1) {
                        System.out.println(index);
                    } else {
                        System.out.println("No matches");

                    }
                } else {
                    int index = findOddIndex(number);
                    if (index != -1) {
                        System.out.println(index);
                    } else {
                        System.out.println("No matches");

                    }

                }
            } else if (command[0].equals("min")) {
                if (command[1].equals("even")) {
                    int index = findMinEvenIndex(number);
                    if (index != -1) {
                        System.out.println(index);
                    } else {
                        System.out.println("No matches");

                    }
                } else {
                    int index = findMinOddIndex(number);
                    if (index != -1) {
                        System.out.println(index);
                    } else {
                        System.out.println("No matches");

                    }

                }
            } else if (command[0].equals("first")) {
                int count = Integer.parseInt(command[1]);
                if (command[2].equals("even")) {
                    if (count <= number.length) {
                        printFirstEven(number, count);
                    } else {
                        System.out.println("Invalid count");
                    }
                } else {
                    int oddCount = Integer.parseInt(command[1]);
                    if (oddCount <= number.length) {
                        printFirstOdd(number, count);
                    } else {
                        System.out.println("Invalid count");
                    }


                }
            } else if (command[0].equals("last")) {
                int count = Integer.parseInt(command[1]);
                if (command[2].equals("even")) {
                    if (count <= number.length) {
                        printLastEven(number, count);
                    } else {
                        System.out.println("Invalid count");
                    }
                } else {
                    int oddCount = Integer.parseInt(command[1]);
                    if (oddCount <= number.length) {
                        printLastOdd(number, count);
                    } else {
                        System.out.println("Invalid count");
                    }


                }
            }

            input = scanner.nextLine();

        }
        printArray(number);
    }

    private static void printLastEven(int[] number, int count) {
        int[] arr = new int[number.length];
        for (int i = number.length - 1; i >= 0; i--) {
            if (number[i] % 2 == 0 && count > 0) {
                count--;
                arr[i] = number[i];
            } else {
                arr[i] = -1;
            }

        }
        printArray(arr);


    }
    private static void printLastOdd(int[] number, int count) {
        int[] arr = new int[number.length];
        for (int i = number.length - 1; i >= 0; i--) {
            if (number[i] % 2 != 0 && count > 0) {
                count--;
                arr[i] = number[i];
            } else {
                arr[i] = -1;
            }

        }
        printArray(arr);


    }

    private static void printFirstOdd(int[] number, int count) {
        int[] arr = new int[number.length];
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 != 0 && count > 0) {
                count--;
                arr[i] = number[i];
            } else {
                arr[i] = -1;
            }

        }
        printArray(arr);


    }

    private static void printFirstEven(int[] number, int count) {
        int[] arr = new int[number.length];
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 == 0 && count > 0) {
                count--;
                arr[i] = number[i];
            } else {
                arr[i] = -1;
            }

        }
        printArray(arr);
    }

    private static int findMinOddIndex(int[] number) {
        int index = -1;

        int maxNum = Integer.MAX_VALUE;

        for (int i = 0; i < number.length; i++) {
            if (maxNum >= number[i] && number[i] % 2 != 0) {
                maxNum = number[i];
                index = i;

            }

        }

        return index;
    }

    private static int findMinEvenIndex(int[] number) {
        int index = -1;

        int maxNum = Integer.MAX_VALUE;

        for (int i = 0; i < number.length; i++) {
            if (maxNum >= number[i] && number[i] % 2 == 0) {
                maxNum = number[i];
                index = i;

            }

        }

        return index;
    }

    private static int findOddIndex(int[] number) {
        int index = -1;

        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < number.length; i++) {
            if (maxNum <= number[i] && number[i] % 2 != 0) {
                maxNum = number[i];
                index = i;

            }

        }

        return index;

    }

    private static int findEvenIndex(int[] number) {
        int index = -1;

        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < number.length; i++) {
            if (maxNum <= number[i] && number[i] % 2 == 0) {
                maxNum = number[i];
                index = i;

            }

        }

        return index;
    }

    private static void printArray(int[] number) {

        System.out.print("[");
        boolean printFirst = true;
        for (int i = 0; i < number.length; i++) {
            if (number[i] != -1) {
                if (printFirst) {

                    System.out.print(number[i]);
                    printFirst = false;
                } else {
                    System.out.print(", " + number[i]);
                }
            }
        }
        System.out.println("]");
    }

    private static void exchange(int[] number, int index) {

        for (int i = 0; i < index + 1; i++) {
            int holder = number[0];
            for (int j = 0; j < number.length - 1; j++) {

                number[j] = number[j + 1];
            }
            number[number.length - 1] = holder;

        }
    }
}

