package model;

import model.Vehicle;

public class Truck extends Vehicle {

    private String plate;
    private String color;

    public Truck(String plate, String color, Matricula matricula) {
        super(matricula);
        this.plate = plate;
        this.color = color;
    }

    @Override
    public String getPlate() {
        return plate;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getType() {
        return "Truck";
    }
}
