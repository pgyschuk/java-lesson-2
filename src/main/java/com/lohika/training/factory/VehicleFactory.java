package com.lohika.training.factory;


import com.lohika.training.exception.VehicleNotReadyException;
import com.lohika.training.model.transportation.Boat;
import com.lohika.training.model.transportation.Car;
import com.lohika.training.model.transportation.VehicleId;

public class VehicleFactory {
    public Car makeCar(int wheels, String color, VehicleId vehicleId) throws VehicleNotReadyException {
        Car.Builder builder = Car.builder();
        Car car = builder.setWheels(wheels).setColor(color).setVehicleId(vehicleId).build();
        return car;
    }

    public Boat makeBoat(String color, VehicleId vehicleId) throws VehicleNotReadyException {
        Boat.Builder builder = Boat.builder();
        Boat boat = builder.setColor(color).setVehicleId(vehicleId).build();
        return boat;
    }

}
