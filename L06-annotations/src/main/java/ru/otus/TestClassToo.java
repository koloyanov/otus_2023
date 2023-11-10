package ru.otus;

import java.util.ArrayList;
import java.util.List;

public class TestClassToo {

    private List<Car> cars;

    @Before
    public void initial() {
        cars = new ArrayList<>();
    }

    @Test
    public void bigCars() {
        cars.add(new Car(Size.BIG));
        cars.add(new Car(Size.BIG));
    }

    @Test
    public void smallCars() {
        cars.add(new Car(Size.SMALL));
        cars.add(new Car(Size.SMALL));
    }

    @Test
    public void middleCars() throws Exception {
        cars.add(new Car(Size.MIDDLE));
        cars.add(new Car(Size.MIDDLE));
    }

    @After
    public void clear() {
        cars.clear();
    }
}
