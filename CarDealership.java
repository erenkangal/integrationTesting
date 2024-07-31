import java.util.ArrayList;
import java.util.List;

class CarDealership {
	private List<Car> inventory;

	public CarDealership() {
		this.inventory = new ArrayList<>();
	}

	public void addCar(Car car) {
		try {
			inventory.add(car);
			System.out.println("Car added successfully!"); // Success message
		} catch (IllegalArgumentException e) {
			System.out.println("Something happened about adding the car: " + e.getMessage());
		}
	}

	public void deleteCar(Car car) {

		inventory.remove(car);
		System.out.println("Car removed successfully!"); // Success message

	}

	public void displayInventory() {
		System.out.println("Current Inventory:");
		for (Car car : inventory) {
			System.out.println(car);
		}
	}

	public void searchByMake(String make) {
		System.out.println("Search Results for Make: " + make);
		for (Car car : inventory) {
			if (car.getMake().equalsIgnoreCase(make)) {
				System.out.println(car);
			}
		}
	}

	public void searchByModel(String model) {
		System.out.println("Search Results for Model: " + model);
		for (Car car : inventory) {
			if (car.getModel().equalsIgnoreCase(model)) {
				System.out.println(car);
			}
		}
	}

	public void searchByYear(int year) {
		System.out.println("Search Results for Year: " + year);
		for (Car car : inventory) {
			if (car.getYear() == year) {
				System.out.println(car);
			}
		}
	}

	public void searchByPrice(double minPrice, double maxPrice) {
		System.out.println("Search Results for Price between $" + minPrice + " and $" + maxPrice);
		for (Car car : inventory) {
			double price = car.getPrice();
			if (price >= minPrice && price <= maxPrice) {
				System.out.println(car);
			}
		}
	}

	public List<Car> getInventory() {
		return inventory;
	}

	public void setInventory(List<Car> inventory) {
		this.inventory = inventory;
	}

}
