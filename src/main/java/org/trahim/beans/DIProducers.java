package org.trahim.beans;

import org.trahim.beans.disposes.Car;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

public class DIProducers {
    @Produces
    String s = "Hello from producers!";
    @Produces
    int i = 8;
    @Produces
    double getDouble() {
        return 3.5 * 7 + 1;
    }

    @Produces
    public Car getCar() {
        return new Car("Lada.");
    }

    public void clean(@Disposes Car car) {
        car.clean();
    }
}
