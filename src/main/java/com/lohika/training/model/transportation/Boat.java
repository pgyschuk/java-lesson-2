package com.lohika.training.model.transportation;

import com.lohika.training.exception.VehicleNotReadyException;

/**
 * Model represent water transport
 */
public class Boat extends Vehicle {
    private VehicleId vehicleId;
    private String color;

    private void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }


    private Boat() {
    }

    public static Boat.Builder builder() {
        return new Boat.Builder(new Boat());
    }

    public static class Builder extends Vehicle.Builder<Boat> {
        private Boat boat = new Boat();

        public Builder(Boat vehicle) {
            super(vehicle);
        }

        public Boat.Builder setColor(String color) {
            boat.setColor(color);
            return this;
        }

        public Boat.Builder setVehicleId(VehicleId vehicleId) {
            boat.setVehicleId(vehicleId);
            return this;
        }

        public Boat build() throws VehicleNotReadyException {
            if (boat.getColor() == null || boat.getVehicleId() == null) {
                throw new VehicleNotReadyException("Boat configuration is not correct");
            }
            return boat;
        }
    }
}
