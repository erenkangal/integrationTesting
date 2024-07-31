import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarDealershipParameterizedTest {

	private CarDealership dealership;

	@BeforeEach
	public void setup() {
		dealership = new CarDealership();

		dealership.addCar(new Car("Toyota", "Camry", 2018, 25000, "V6", 4));
		dealership.addCar(new Car("Honda", "Accord", 2019, 27000, "Inline-4", 4));
		dealership.addCar(new Car("Ford", "Mustang", 2020, 35000, "V8", 2));
	}

	@ParameterizedTest
	@ValueSource(strings = { "Toyota", "Honda", "Mercedes" })
	public void testSearchByMake(String make) {
		// Perform the search
		dealership.searchByMake(make);

		assertTrue(dealership.getInventory().stream().anyMatch(car -> car.getMake().equalsIgnoreCase(make)),
				"Search by make should return cars with the specified make: " + make);

	}

}
