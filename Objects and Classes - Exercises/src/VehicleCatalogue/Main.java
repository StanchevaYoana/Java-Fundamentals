package VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    static void printVehicle(List<VehicleCatalogue> vehicleCatalogueList, String input2) {
        for (VehicleCatalogue vehicle : vehicleCatalogueList) {
            if (vehicle.getModel().equals(input2)) {
                System.out.println(vehicle.toString());
            }
        }
    }

    static double averageCars(List<VehicleCatalogue> vehicleCatalogueList, double sum, int count) {

        for (VehicleCatalogue vehicle : vehicleCatalogueList) {
            if (vehicle.getType().equals("Car")) {
                sum += vehicle.getHorsepower();
                count++;
            }
        }
        if (count != 0) {
            return sum / count;
        } else {
            return 0;
        }
    }

    static double averageTrucks(List<VehicleCatalogue> vehicleCatalogueList, double sum, int count) {

        for (VehicleCatalogue vehicle : vehicleCatalogueList) {
            if (vehicle.getType().equals("Truck")) {
                sum += vehicle.getHorsepower();
                count++;
            }
        }
        if (count != 0) {
            return sum / count;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<VehicleCatalogue> vehicleCatalogueList = new ArrayList<>();
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] data = input.split("\\s+");

            VehicleCatalogue vehicleCatalogue =
                    new VehicleCatalogue(data[0].substring(0,1).toUpperCase()+ data [0].substring(1),
                            data[1], data[2],
                            Integer.parseInt(data[3]));

            vehicleCatalogueList.add(vehicleCatalogue);

            input = scanner.nextLine();
        }

        String input2 = scanner.nextLine();
        while (!"Close the Catalogue".equals(input2)) {
            printVehicle(vehicleCatalogueList, input2);

            input2 = scanner.nextLine();

        }
        double sum = 0;
        int count = 0;

        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCars(vehicleCatalogueList, sum, count));
        System.out.printf("Trucks have average horsepower of: %.2f.", averageTrucks(vehicleCatalogueList, sum, count));

    }
}
