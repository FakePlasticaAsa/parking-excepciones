package model;

public class Matricula {
    private String plateNumber;
    private String vehicleType;
    private String owner;

    public Matricula(String plateNumber, String vehicleType, String owner) {
        this.plateNumber = plateNumber;
        this.vehicleType = vehicleType;
        this.owner = owner;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "plateNumber='" + plateNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
