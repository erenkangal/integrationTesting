import java.util.Scanner;

public class CarSaleSystem {
    public static void main(String[] args) {
        CarDealership dealership = new CarDealership();
        Scanner scanner = new Scanner(System.in);

        // Adding some sample cars
        dealership.addCar(new Car("Toyota", "Corolla", 2023, 25000, "V3", 4));
        dealership.addCar(new Car("Honda", "Accord", 2019, 27000, "V4", 4));
        dealership.addCar(new Car("Ford", "Mustang", 2020, 35000, "V8", 2));
        dealership.addCar(new Car("Renault", "Megane", 2017, 15000, "V4", 4));
        dealership.addCar(new Car("Honda", "Civic", 2022, 20000, "V4", 4));
        dealership.addCar(new Car("Renault", "Clio", 2019, 17000, "V3", 4));
        dealership.addCar(new Car("Mercedes", "C200", 2016, 24000, "V4", 4));
        dealership.addCar(new Car("Toyota", "Auris", 2013, 10000, "V3", 4));
        dealership.addCar(new Car("Fiat", "Egea", 2019, 12000, "V4", 4));
        dealership.addCar(new Car("Opel", "Astra", 2022, 18000, "V4", 4));
        dealership.addCar(new Car("Skoda", "SuperB", 2019, 20000, "V4", 4));
        dealership.addCar(new Car("Hyundai", "i20", 2021, 17000, "V4", 4));
        dealership.addCar(new Car("Volkswagen", "Passat", 2017, 21000, "V4", 4));
        dealership.addCar(new Car("Audi", "A5 Coupe", 2023, 48000, "V6", 2));



        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display Inventory");
            System.out.println("2. Search by Make");
            System.out.println("3. Search by Model");
            System.out.println("4. Search by Year");
            System.out.println("5. Search by Price");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    dealership.displayInventory();
                    break;
                case 2:
                    System.out.print("Enter make to search: ");
                    String make = scanner.nextLine();
                    dealership.searchByMake(make);
                    break;
                case 3:
                    System.out.print("Enter model to search: ");
                    String model = scanner.nextLine();
                    dealership.searchByModel(model);
                    break;
                case 4:
                    System.out.print("Enter year to search: ");
                    int year = scanner.nextInt();
                    dealership.searchByYear(year);
                    break;
                case 5:
                    System.out.print("Enter minimum price: ");
                    double minPrice = scanner.nextDouble();
                    System.out.print("Enter maximum price: ");
                    double maxPrice = scanner.nextDouble();
                    dealership.searchByPrice(minPrice, maxPrice);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
