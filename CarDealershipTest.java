import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class CarDealershipTest {

    CarDealership dealership = new CarDealership();

	
    Car car = new Car("Toyota", "Corolla", 2023, 25000, "V4", 4);
    Car car2 = new Car("Renault", "Clio", 2019, 17000, "V4", 4);


 ///////////// Assertion 1: assertEquals  ///////////// 
  @Test
  public void testModelCar() {
	  	assertEquals("Models does not match!", "Corolla", car.getModel()); //True Case
  }
  
  @Test
  public void testMakeCar() {  
	    assertEquals("Brands does not match!","Honda", car.getMake());
  }
  
  @Test
  public void testYear() {
	    assertEquals("Years does not match!","2022", car.getYear()); 
	     ////The codes below are the mutation versions of the code ABOVE
	    assertEquals("Years does not match!","2021", car.getEngineType()); 
	    assertEquals("Years does not match!","2023", car.getYear()); 

	}
  
  @Test
  public void testEngineType() {
	    
	    assertEquals("Engine types does not match!" ,"V4", car.getEngineType()); //True Case
	}
  
  
///////////// Assertion 2: assertNotSame ///////////// 
  
  @Test
  public void testEngineTypesNotSame() {
	  
	  assertNotSame("Engine types should not be same!",car.getEngineType(),car2.getEngineType());
  }
  
  @Test
  public void testModelsNotSame() {
	  
	  assertNotSame("Models should not be same!",car.getModel(),car2.getModel());
  }
  
  @Test
  public void testNumbersofDoorsNotSame() {
	  
	  assertNotSame("Number of doors should not be same!",car.getNumberOfDoors(),car2.getNumberOfDoors());
  }
  
  @Test
  public void testCarBrandNotSame() {
	  
	  assertNotSame("Car brands should not be same!",car.getMake(),car2.getMake());
  }
  
  
///////////// Assertion 3: assertTrue ///////////// 


  @Test
  public void testPriceGreaterThanZero() {
      assertTrue("Price should be greater than zero!", car.getPrice() > 0);
      ////The codes below are the mutation versions of the code ABOVE
	  assertTrue("Price can be negative!", car.getPrice() <= 0);

  }

  @Test
  public void testModelIsNotMatch() {
	  assertTrue("Car model must be corolla!", car.getModel() != "Auris");
      ////The codes below are the mutation versions of the code ABOVE
	  assertTrue("Car make must not be corolla!", car.getMake() != "Corolla");
	  assertTrue("Car model must be corolla!", car.getModel() != "Camry");


      
  }
  
  @Test
  public void testCar2BrandIsMatch() {
      assertTrue("Car brand must be Reanult!", car2.getMake() != "Mercedes");
      ////The codes below are the mutation versions of the code ABOVE
      assertTrue("Car brand must be Reanult!", car2.getMake() == "Mercedes");

  }
  
  @Test
  public void testYearInRange() {
      assertTrue("Year should be between 2000 and 2025!", car.getYear() >= 2000 && car.getYear() <= 2025);
      ////The codes below are the mutation versions of the code ABOVE
      assertTrue("Year must not be less than 2021!", car.getYear() >= 2021);

  }

  
///////////// Assertion 4: assertNotNull ///////////// 

  @Test
  public void testMakeNotNull() {
      assertNotNull("Make should not be null!", car.getMake());
  }

  @Test
  public void testModelNotNull() {
      assertNotNull("Model should not be null!", car.getModel());
  }


///////////// Assertion 5: assertFalse ///////////// 

  @Test
  public void testPriceNotZero() {
      assertFalse("Price should not be zero!", car.getPrice() == 0);
  }
  
  @Test
  public void testModelNotZero() {
      assertFalse("Car must has a model!", car.getModel() == null);
      ////The codes below are the mutation versions of the code ABOVE
      assertFalse("Car must has a model!", car.getMake() != null);

  }
  
  ///////////// Assertion 6: assertNull ///////////// 

  @Test
  public void testEngineTypeNull() {
      assertNull("Engine type should be null!", car2.getEngineType());
  }
  
  @Test
  public void testMakeNull() {
      assertNull("Car brand should be null!", car.getMake());
  }
  
  ///////////// COMBINED CASES  ///////////// 

  
  @Test
  public void testAddCar() {
      Car car = new Car("Audi", "A3", 2023, -45000, "V6", 4);
      dealership.addCar(car);
      assertEquals(1, dealership.getInventory().size());
      assertTrue(dealership.getInventory().contains(car));
  }
  

  @Test
  public void testDeleteCar() {
	  
      Car car3 = new Car("BMW", "520", 2016, 35000, "V6", 4);
      dealership.addCar(car);
      assertEquals(1, dealership.getInventory().size());

      // Deleting the car
      dealership.deleteCar(car);
      assertEquals(0, dealership.getInventory().size());
      assertTrue(dealership.getInventory().contains(car3));
  }
}
