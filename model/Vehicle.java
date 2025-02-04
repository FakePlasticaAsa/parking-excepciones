package model;

public abstract class Vehicle {
    private Matricula matricula;

    public Vehicle(Matricula matricula) {
        this.matricula = matricula;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    abstract String getPlate();

    abstract String getColor();

    abstract String getType();
}
