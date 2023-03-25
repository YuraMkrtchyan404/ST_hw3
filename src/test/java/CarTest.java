import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
public class CarTest {
    private Car car;

    @BeforeMethod
    public void setUp() {
        car = new Car("Toyota", "Camry", 2022);
    }

    @Test
    public void testStart() {
        Assert.assertEquals(car.start(), "Starting the car...");
        Assert.assertTrue(car.isRunning());
        Assert.assertEquals(car.getSpeed(), 0);
        Assert.assertEquals(car.start(), "The car is already running.");
    }

    @Test
    public void testStop() {
        car.start();
        car.accelerate(50);
        Assert.assertEquals(car.stop(), "Stopping the car...");
        Assert.assertEquals(car.getSpeed(), 0);
        Assert.assertFalse(car.isRunning());
        Assert.assertEquals(car.stop(), "The car is already stopped.");
    }

    @Test
    public void testAccelerate() {
        Assert.assertEquals(car.accelerate(10), "The car is not running. Please start the car first.");
        car.start();
        Assert.assertEquals(car.accelerate(50), "Accelerating to 50 km/h");
        Assert.assertEquals(car.getSpeed(), 50);

        Assert.assertEquals(car.accelerate(120), "Invalid speed. Please enter a speed between 1 and 100 km/h.");
        Assert.assertEquals(car.getSpeed(), 50);
    }

    @Test
    public void testBrake() {
        Assert.assertEquals(car.brake(), "The car is not running. Please start the car first.");

        car.stop();
        car.start();
        car.accelerate(60);
        Assert.assertEquals(car.brake(), "Applying the brakes...");
        Assert.assertEquals(car.getSpeed(), 0);
    }
}

