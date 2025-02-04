package model;

import model.Parking;
import model.Vehicle;
import java.time.LocalDateTime;

public class Ticket {
    private Parking parking;
    private int floor;
    private int spot;
    private Vehicle vehicle;
    private LocalDateTime dateTime;
    
    public Ticket(Parking parking, int floor, int spot, Vehicle vehicle, LocalDateTime dateTime) {
        this.parking = parking;
        this.floor = floor;
        this.spot = spot;
        this.vehicle = vehicle;
        this.dateTime = dateTime;
    }
    
    public void print() {
        System.out.println("TICKET DE ENTRADA");
        System.out.println(parking.getName());
        System.out.println(parking.getAddress());
        System.out.println(parking.getPhone());
        System.out.println(parking.getId());
        System.out.println(dateTime);
        System.out.println();
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSpot() {
        return spot;
    }

    public void setSpot(int spot) {
        this.spot = spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
