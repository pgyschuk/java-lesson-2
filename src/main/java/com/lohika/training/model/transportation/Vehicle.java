package com.lohika.training.model.transportation;

import com.lohika.training.exception.VehicleNotReadyException;

/**
 * Model represent abstract vehicle with common fields for any kind of transportation
 */
public abstract class Vehicle {
    private VehicleId vehicleId;

    public VehicleId getVehicleId() {
        return vehicleId;
    }

    protected void setVehicleId(VehicleId vehicleId) {
        this.vehicleId = vehicleId;
    }

    public abstract static class Builder<T extends Vehicle> {
        T vehicle;

        public Builder(T vehicle) {
            this.vehicle = vehicle;
        }

        public Builder<T> setVehicleId(VehicleId vehicleId) {
            vehicle.setVehicleId(vehicleId);
            return this;
        }

        abstract public T build() throws VehicleNotReadyException;
    }
}
