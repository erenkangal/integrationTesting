import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@SuiteDisplayName("Car Dealership Parameterized Test Suite")
@SelectClasses({
        CarDealershipParameterizedTest.class
})

public class CarDealershipParameterizedTestSuite {
}
