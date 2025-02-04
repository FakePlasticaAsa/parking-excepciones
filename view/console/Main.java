package view.console;

import model.Parking;
import model.Car;
import model.Bike;
import model.Truck;
import model.Vehicle;
import model.Matricula;
import model.MatriculaException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Parking parking = new Parking("PR123", "Monlau City", "Sigan 123", "123-456-7890", 3, 10, 5.0, 2.0, 3.0);
        
        while (true) {
            System.out.println("\nParking Management System");
            System.out.println("1. Park a vehicle");
            System.out.println("2. Remove a vehicle");
            System.out.println("3. Show available spaces");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                
                try {
                    switch (choice) {
                        case 1:
                            try {
                                System.out.print("Type: ");
                                String type = scanner.nextLine().toLowerCase();

                                System.out.print("Plate: ");
                                String plate = scanner.nextLine();

                                System.out.print("Color: ");
                                String color = scanner.nextLine();

                                System.out.print("Owner: ");
                                String owner = scanner.nextLine();

                                Matricula matricula = new Matricula(plate, type, owner);

                                Vehicle vehicle;
                                switch (type) {
                                    case "car":
                                        vehicle = new Car(plate, color, matricula);
                                        break;
                                    case "bike":
                                        vehicle = new Bike(plate, color, matricula);
                                        break;
                                    case "truck":
                                        vehicle = new Truck(plate, color, matricula);
                                        break;
                                    default:
                                        throw new MatriculaException("Invalid vehicle type.", matricula);
                                }

                                String ticket = parking.parkVehicle(vehicle);
                                System.out.println("Parking result: " + ticket);
                            } catch (MatriculaException e) {
                                System.out.println("Error: " + e.getMensaje());
                                System.out.println("Matricula: " + e.getMatricula());
                            }
                            break;
                        
                        case 2:
                            System.out.print("Enter ticket number: ");
                            String ticketNumber = scanner.nextLine();
                            
                            System.out.print("Enter vehicle type (Car, Bike, Truck): ");
                            String vehicleType = scanner.nextLine();
                            
                            Vehicle exitingVehicle;
                            switch (vehicleType.toLowerCase()) {
                                case "car":
                                    exitingVehicle = new Car("", "", null);
                                    break;
                                case "bike":
                                    exitingVehicle = new Bike("", "", null);
                                    break;
                                case "truck":
                                    exitingVehicle = new Truck("", "", null);
                                    break;
                                default:
                                    throw new MatriculaException("Invalid vehicle type.", null);
                            }
                            
                            parking.removeVehicle(ticketNumber, exitingVehicle);
                            System.out.println("Vehicle removed.");
                            break;
                        
                        case 3:
                            parking.showAvailableSpaces();
                            break;
                        
                        case 4:
                            System.out.println("Exiting...");
                            scanner.close();
                            return;
                        
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine();
            }
        }
    }
}
