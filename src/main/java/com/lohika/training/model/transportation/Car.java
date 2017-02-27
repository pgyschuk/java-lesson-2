package com.lohika.training.model.transportation;

import com.lohika.training.exception.VehicleNotReadyException;

/**
 * Model for representation information about car
 */
public class Car extends Vehicle {

    private int wheels;
    private String color;

    private void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getWheels() {
        return wheels;
    }

    private void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }


    private Car() {
    }

    public static Builder builder() {
        return new Builder(new Car());
    }

    public static class Builder extends Vehicle.Builder<Car> {

        public Builder(Car vehicle) {
            super(vehicle);
        }

        public Builder setWheels(int wheels) {
            vehicle.setWheels(wheels);
            return this;
        }

        public Builder setColor(String color) {
            vehicle.setColor(color);
            return this;
        }

        public Car build() throws VehicleNotReadyException {
            if (vehicle.getWheels() < 3 || vehicle.getColor() == null || vehicle.getVehicleId() == null) {
                throw new VehicleNotReadyException("Car configuration is not correct");
            }
            return vehicle;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "wheels=" + wheels +
                ", color='" + color + '\'' +
                '}';
    }
}
