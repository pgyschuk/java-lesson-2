package com.lohika.training.model.transportation;

/**
 * Model represent unique car id
 */
public class VehicleId {
    private String licensePlate;
    private String vinCode;


    public VehicleId(String licensePlate, String vinCode) {
        this.licensePlate = licensePlate;
        this.vinCode = vinCode;
    }

    private void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    private void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getVinCode() {
        return vinCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleId vehicleId = (VehicleId) o;

        if (licensePlate != null ? !licensePlate.equals(vehicleId.licensePlate) : vehicleId.licensePlate != null) return false;
        return vinCode != null ? vinCode.equals(vehicleId.vinCode) : vehicleId.vinCode == null;
    }

    @Override
    public int hashCode() {
        int result = licensePlate != null ? licensePlate.hashCode() : 0;
        result = 31 * result + (vinCode != null ? vinCode.hashCode() : 0);
        return result;
    }
}
