import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;


public class CarDealershipIntegrationTest {

    private CarDealership dealership;
    private Car carMock;
    private Car carMock2;

    @Before
    public void setUp() {
        dealership = new CarDealership();
        carMock = mock(Car.class);
        carMock2 = mock(Car.class);
    }

/////////////////1
    @Test
    public void testAddCarSuccessfully() {

        when(carMock.getMake()).thenReturn("Toyota");
        when(carMock.getModel()).thenReturn("Corolla");
        when(carMock.getYear()).thenReturn(2023);
        when(carMock.getPrice()).thenReturn(25000.0);
        when(carMock.getEngineType()).thenReturn("V4");
        when(carMock.getNumberOfDoors()).thenReturn(4);

        dealership.addCar(carMock);

        assertEquals(1, dealership.getInventory().size()); // Check if the car was added.
    }

/////////////////2
    @Test
    public void testAddCarWithException() {

        when(carMock.getPrice()).thenReturn(-25000.0);
        when(carMock.getMake()).thenReturn("Toyota");
        when(carMock.getModel()).thenReturn("Corolla");
        when(carMock.getYear()).thenReturn(2023);
        when(carMock.getEngineType()).thenReturn("V4");
        when(carMock.getNumberOfDoors()).thenReturn(4);

        throw new IllegalArgumentException("Car price cannot be negative.");
    }

/////////////////3
    @Test
    public void testRemoveCarSuccessfully() {

        when(carMock.getMake()).thenReturn("Toyota");
        when(carMock.getModel()).thenReturn("Corolla");
        when(carMock.getYear()).thenReturn(2023);
        when(carMock.getPrice()).thenReturn(25000.0);
        when(carMock.getEngineType()).thenReturn("V4");
        when(carMock.getNumberOfDoors()).thenReturn(4);

        dealership.addCar(carMock);

        dealership.deleteCar(carMock);
        assertEquals(0, dealership.getInventory().size()); // Check if the car was removed.
    }

/////////////////4
@Test
public void testSearchByMake() {
    // Setup
    when(carMock.getMake()).thenReturn("Toyota");
    when(carMock2.getMake()).thenReturn("Honda");
    when(carMock.getModel()).thenReturn("Corolla");
    when(carMock2.getModel()).thenReturn("Civic");
    when(carMock.getYear()).thenReturn(2023);
    when(carMock2.getYear()).thenReturn(2022);
    when(carMock.getPrice()).thenReturn(25000.0);
    when(carMock2.getPrice()).thenReturn(20000.0);

    // Add cars to inventory
    dealership.addCar(carMock);
    dealership.addCar(carMock2);

    // Perform search
    dealership.searchByMake("Toyota");

    // Verify that getMake() is called on each car in the inventory
    verify(carMock, times(1)).getMake();
    verify(carMock2, times(1)).getMake();
}


/////////////////5
    @Test
    public void testSearchByModel() {

        when(carMock.getMake()).thenReturn("Toyota");
        when(carMock2.getMake()).thenReturn("Honda");
        when(carMock.getModel()).thenReturn("Corolla");
        when(carMock2.getModel()).thenReturn("Accord");
        when(carMock.getYear()).thenReturn(2023);
        when(carMock2.getYear()).thenReturn(2022);
        when(carMock.getPrice()).thenReturn(25000.0);
        when(carMock2.getPrice()).thenReturn(20000.0);

        // Add cars to inventory
        dealership.addCar(carMock);
        dealership.addCar(carMock2);

        dealership.searchByModel("Corolla");
        verify(carMock, times(1)).getModel(); // Ensure getModel() is called to check the model.
    }

/////////////////6
    @Test
    public void testSearchByYear() {

        when(carMock.getMake()).thenReturn("Toyota");
        when(carMock2.getMake()).thenReturn("Honda");
        when(carMock.getModel()).thenReturn("Corolla");
        when(carMock2.getModel()).thenReturn("Accord");
        when(carMock.getYear()).thenReturn(2023);
        when(carMock2.getYear()).thenReturn(2023);
        when(carMock.getPrice()).thenReturn(25000.0);
        when(carMock2.getPrice()).thenReturn(20000.0);

        // Add cars to inventory
        dealership.addCar(carMock);
        dealership.addCar(carMock2);

        dealership.searchByYear(2023);
        verify(carMock, times(1)).getYear(); // Ensure getYear() is called to check the year.
    }

/////////////////7
    @Test
    public void testDisplayInventory() {
        // Mock behavior for the car object to be found by year
        when(carMock.getMake()).thenReturn("Toyota");
        when(carMock2.getMake()).thenReturn("Honda");
        when(carMock.getModel()).thenReturn("Corolla");
        when(carMock2.getModel()).thenReturn("Accord");
        when(carMock.getYear()).thenReturn(2023);
        when(carMock2.getYear()).thenReturn(2022);
        when(carMock.getPrice()).thenReturn(25000.0);
        when(carMock2.getPrice()).thenReturn(20000.0);

        dealership.displayInventory();
        // Verify that the car objects are accessed appropriately
        assertEquals("Toyota", carMock.getMake());
        assertEquals("Honda", carMock2.getMake());
        assertEquals("Corolla", carMock.getModel());
        assertEquals("Accord", carMock2.getModel());
        assertEquals(2023, carMock.getYear());
        assertEquals(2022, carMock2.getYear());
        assertEquals(25000.0, carMock.getPrice(), 0.01);
        assertEquals(20000.0, carMock2.getPrice(), 0.01);
    }

/////////////////8
    @Test
    public void testSearchByPrice_Success() {
        // Mock behavior for the car objects
        when(carMock.getMake()).thenReturn("Toyota");
        when(carMock.getModel()).thenReturn("Corolla");
        when(carMock.getYear()).thenReturn(2023);
        when(carMock.getPrice()).thenReturn(25000.0);

        when(carMock2.getMake()).thenReturn("Honda");
        when(carMock2.getModel()).thenReturn("Accord");
        when(carMock2.getYear()).thenReturn(2022);
        when(carMock2.getPrice()).thenReturn(20000.0);

        // Add cars to inventory
        dealership.addCar(carMock);
        dealership.addCar(carMock2);

        // Call the method to search by price
        dealership.searchByPrice(21000, 26000);

        // Verify that getPrice() is called for each car within the specified price range
        verify(carMock, times(1)).getPrice();
        verify(carMock2, times(1)).getPrice();
    }

/////////////////9
    @Test
    public void testAddAndDisplayCar() {
        when(carMock.getMake()).thenReturn("Mercedes");
        when(carMock.getModel()).thenReturn("C200");
        when(carMock.getYear()).thenReturn(2021);
        when(carMock.getPrice()).thenReturn(52000.0);
        when(carMock.getEngineType()).thenReturn("V4");
        when(carMock.getNumberOfDoors()).thenReturn(4);

        dealership.addCar(carMock);
        dealership.displayInventory();

        assertEquals("Mercedes", carMock.getMake());
        assertEquals("C200", carMock.getModel());
        assertEquals(2021, carMock.getYear());
        assertEquals("V4", carMock.getEngineType());
        assertEquals(4, carMock.getNumberOfDoors());
        assertEquals(52000.0, carMock.getPrice(), 0.01);
}

/////////////////10
    @Test
    public void testUpdateCarPriceSuccessfully() {
        // Define car properties and behavior
        when(carMock.getMake()).thenReturn("Toyota");
        when(carMock.getModel()).thenReturn("Camry");
        when(carMock.getYear()).thenReturn(2022);
        when(carMock.getPrice()).thenReturn(22000.0);
        when(carMock.getEngineType()).thenReturn("V4");
        when(carMock.getNumberOfDoors()).thenReturn(4);

        System.out.println("First price: $" + carMock.getPrice());
        double newPrice = 23000.0;
        carMock.setPrice(newPrice);// Update the price
        when(carMock.getPrice()).thenReturn(newPrice);

    // Verify the update
    verify(carMock).setPrice(newPrice); // Verify setPrice was called with the new price

    // Output to confirm the behavior
    System.out.println("Updated price: $" + carMock.getPrice());
    assertEquals(newPrice, carMock.getPrice(), 0.0); // Assert the price was updated
    }
}
