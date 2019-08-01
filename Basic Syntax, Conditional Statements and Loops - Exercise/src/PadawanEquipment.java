import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine());
        int student = Integer.parseInt(scanner.nextLine());
        double sabre = Double.parseDouble(scanner.nextLine());
        double robe = Double.parseDouble(scanner.nextLine());
        double belt = Double.parseDouble(scanner.nextLine());
        double lightsabers = Math.ceil(student + student * 0.1);
       double freeBelt = 0;
        if (student >= 6) {
           freeBelt = Math.ceil(student / 6);
        }
        double neededBelt = student - freeBelt;
        double neededPadawan = (lightsabers * sabre) + (robe * student) + (neededBelt*belt);

        if (money >= neededPadawan) {
            System.out.printf("The money is enough - it would cost %.2flv.", neededPadawan);
        } else if (money < neededPadawan){
            System.out.printf("Ivan Cho will need %.2flv more.",neededPadawan - money);

        }
    }
}
