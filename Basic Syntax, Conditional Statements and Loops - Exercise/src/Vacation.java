import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();

        double totalPrice = 0;
        switch (day) {
            case "Friday":
                if ("Students".equals(type)) {
                    totalPrice = num * 8.45;
                    if (num >= 30) {
                        totalPrice = totalPrice * 0.85;
                    }
                } else if ("Business".equals(type)) {
                    totalPrice = num * 10.90;
                    if (num >= 100) {
                        totalPrice = totalPrice - (10 * 10.90);
                    }
                } else if ("Regular".equals(type)) {
                    totalPrice = num * 15;
                    if (num >= 10 && num <= 20) {
                        totalPrice = totalPrice * 0.95;
                    }
                }
                break;

            case "Saturday":
                if ("Students".equals(type)) {
                    totalPrice = num * 9.80;
                    if (num >= 30) {
                        totalPrice = totalPrice * 0.85;
                    }
                } else if ("Business".equals(type)) {
                    totalPrice = num * 15.60;
                    if (num >= 100) {
                        totalPrice = totalPrice - (10 * 15.60);
                    }
                } else if ("Regular".equals(type)) {
                    totalPrice = num * 20;
                    if (num >= 10 && num <= 20) {
                        totalPrice = totalPrice * 0.95;
                    }
                }
                break;
            case "Sunday":
                if ("Students".equals(type)) {
                    totalPrice = num * 10.46;
                    if (num >= 30) {
                        totalPrice = totalPrice * 0.85;
                    }
                } else if ("Business".equals(type)) {
                    totalPrice = num * 16;
                    if (num >= 100) {
                        totalPrice = totalPrice - (10 * 16);
                    }
                } else if ("Regular".equals(type)) {
                    totalPrice = num * 22.50;
                    if (num >= 10 && num <= 20) {
                        totalPrice = totalPrice * 0.95;
                    }
                    break;
                }
        }
                System.out.printf("Total price: %.2f", totalPrice);
        }
    }
