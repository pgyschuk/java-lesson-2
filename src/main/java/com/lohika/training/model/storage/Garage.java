package com.lohika.training.model.storage;

import java.util.HashMap;
import java.util.Map;

import com.lohika.training.model.transportation.Vehicle;
import com.lohika.training.model.transportation.VehicleId;

/**
 * Model represent collection of vehicles
 */
public class Garage<T extends Vehicle>  {
    private Map<VehicleId, T> vehicles = new HashMap<>();

    public Map<VehicleId, T> getVehicles() {
        return vehicles;
    }

    public void addVehicle(T vehicle){
        vehicles.put(vehicle.getVehicleId(), vehicle);
    }

    public T getVehicle(VehicleId vehicleId) {
        return vehicles.get(vehicleId);
    }

}
