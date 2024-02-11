package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CarShopTests {
    private CarShop carShop;

    @Before
    public void setUp() {
        carShop = new CarShop();
    }
    @Test
    public void testAddCar() {
        Car car = new Car("Model1", 200, 30000.0);
        carShop.add(car);

        Assert.assertEquals(1, carShop.getCount());
        Assert.assertTrue(carShop.getCars().contains(car));
    }
    @Test
    public void testRemoveCar() {
        Car car = new Car("Model1", 200, 30000.0);
        carShop.add(car);

        boolean removed = carShop.remove(car);

        Assert.assertTrue(removed);
        Assert.assertEquals(0, carShop.getCount());
    }
    @Test
    public void testFindAllCarsWithMaxHorsePower() {
        Car car1 = new Car("Model1", 250, 40000.0);
        Car car2 = new Car("Model2", 220, 35000.0);
        carShop.add(car1);
        carShop.add(car2);

        List<Car> result = carShop.findAllCarsWithMaxHorsePower(230);

        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.contains(car1));
    }
    @Test
    public void testGetTheMostLuxuryCar() {
        Car car1 = new Car("Model1", 250, 40000.0);
        Car car2 = new Car("Model2", 220, 45000.0);
        carShop.add(car1);
        carShop.add(car2);

        Car mostLuxuryCar = carShop.getTheMostLuxuryCar();

        Assert.assertEquals(car2, mostLuxuryCar);
    }
    @Test
    public void testFindAllCarByModel() {
        Car car1 = new Car("Model1", 250, 40000.0);
        Car car2 = new Car("Model1", 220, 35000.0);
        carShop.add(car1);
        carShop.add(car2);

        List<Car> result = carShop.findAllCarByModel("Model1");

        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.contains(car1));
        Assert.assertTrue(result.contains(car2));
    }
    @Test(expected = NullPointerException.class)
    public void testAddNullCar() {
        carShop.add(null);
    }

}

