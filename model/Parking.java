package model;

import model.Plaza;
import java.util.ArrayList;

public class Parking {

    private String id;
    private String name;
    private String address;
    private String phone;
    private int floors;
    private int floorSpots;
    private double truckTariff;
    private double bikeTariff;
    private double carTariff;
    private Plaza[][] spaces;
    private ArrayList<Ticket> tickets;
    private ArrayList<Matricula> matriculas;

    public Parking(String id, String name, String address, String phone, int numFloors, int spacesPerFloor,
            double truckTariff, double bikeTariff, double carTariff) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.floors = numFloors;
        this.floorSpots = spacesPerFloor;
        this.truckTariff = truckTariff;
        this.bikeTariff = bikeTariff;
        this.carTariff = carTariff;
        this.spaces = new Plaza[numFloors][spacesPerFloor];

        initializeSpaces();
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public int getFloors() {
        return floors;
    }

    public int getFloorSpots() {
        return floorSpots;
    }

    public double getTruckTariff() {
        return truckTariff;
    }

    public double getBikeTariff() {
        return bikeTariff;
    }

    public double getCarTariff() {
        return carTariff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Plaza[][] getSpaces() {
        return spaces;
    }

    public void setSpaces(Plaza[][] spaces) {
        this.spaces = spaces;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    private void initializeSpaces() {
        for (int floor = 0; floor < getFloors(); floor++) {
            for (int space = 0; space < getFloorSpots(); space++) {
                // Los 3 primeros spots para camion
                // Los 5 siguientes para moto
                // Los demas para coches

                String vehicleType = "Car";
                if (space < 3) {
                    vehicleType = "Truck";
                } else if (space >= 3 && space < 8) {
                    vehicleType = "Bike";
                }

                spaces[floor][space] = new Plaza(floor, space, vehicleType);
            }
        }
    }

    public String parkVehicle(Vehicle vehicle) {
        for (int floor = 0; floor < getFloors(); floor++) {
            for (int space = 0; space < getFloorSpots(); space++) {
                Plaza currentSpace = spaces[floor][space];

                if (currentSpace.isAvailable() && currentSpace.isReservedFor(vehicle.getType())) {
                    currentSpace.parkVehicle();
                    return currentSpace.getTicket(this);
                }

            }
        }
        return "No available space for this vehicle type.";
    }

    public void removeVehicle(String ticket, Vehicle vehicle) {
        // FORMATO TICKET PR123_2_5 -> Extraer planta y plaza
        String[] parts = ticket.split("_");
        int floor = Integer.parseInt(parts[1]);
        int spaceNumber = Integer.parseInt(parts[2]);

        Plaza space = spaces[floor][spaceNumber];
        space.removeVehicle();
    }

    public int getAvailableSpacesForType(String vehicleType) {
        int count = 0;
        for (int floor = 0; floor < getFloors(); floor++) {
            for (int space = 0; space < getFloorSpots(); space++) {
                Plaza currentSpace = spaces[floor][space];
                if (currentSpace.isAvailable() && currentSpace.isReservedFor(vehicleType)) {
                    count++;
                }
            }
        }
        return count;
    }

    public void showAvailableSpaces() {
        for (int floor = 0; floor < getFloors(); floor++) {
            for (int space = 0; space < getFloorSpots(); space++) {
                Plaza spaceObj = spaces[floor][space];
                if (spaceObj.isAvailable()) {
                    System.out.println("Floor: " + floor + ", Space: " + space + " (Available)");
                }
            }
        }
    }
}
