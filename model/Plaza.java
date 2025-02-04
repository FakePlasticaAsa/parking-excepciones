package model;

import model.Vehicle;
import model.Ticket;
import java.time.LocalDateTime;

public class Plaza {

    private int floor;
    private int spotNumber;
    private Boolean isAvailable;
    private String vehicleType; // Truck, Bike, or Car
    private Vehicle vehicle;

    public Plaza(int floor, int spotNumber, String vehicleType) {
        this.floor = floor;
        this.spotNumber = spotNumber;
        this.isAvailable = true;
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() {
        if (isAvailable == null) {
            return false;
        }
        return isAvailable;
    }

    public void parkVehicle() {
        this.isAvailable = false;
    }

    public void removeVehicle() {
        this.isAvailable = true;
    }

    public String getTicket(Parking parking) {
        LocalDateTime dateTime = LocalDateTime.now();
        String date = dateTime.toString().split("T")[0];
        String time = dateTime.toString().split("T")[1];
        
        String ticket = "PR" + parking.getId() + "_" + floor + "_" + spotNumber;
        ticket += "\n" + parking.getName();
        ticket += "\n" + parking.getAddress();
        ticket += "\n" + parking.getPhone();
        ticket += "\nFecha de entrada: " + date;
        ticket += "\nHora de entrada: " + time;
        ticket += "\n\n";        
        return ticket;
    }

    public boolean isReservedFor(String vehicleType) {
        return this.vehicleType.equals(vehicleType);
    }
}
