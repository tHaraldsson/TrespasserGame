package se.tommy.adventure.logic;

import se.tommy.adventure.inventory.Inventory;
import se.tommy.adventure.model.Burglar;
import se.tommy.adventure.model.Resident;
import se.tommy.adventure.rooms.Bedroom;
import se.tommy.adventure.rooms.Hallway;
import se.tommy.adventure.rooms.Kitchen;
import se.tommy.adventure.rooms.Office;
import se.tommy.adventure.utilities.Utilz;

public class Game {

    public static boolean running = true;

    private Utilz utilz;
    private Inventory inventory = new Inventory();

    private Kitchen kitchen;
    private Office office;
    private Bedroom bedroom;
    private Hallway hallway;

    private Resident resident;
    private Burglar burglar;


    public Game() {
        this.resident = new Resident(50, 10);
        this.burglar = new Burglar(50, 13);
        this.utilz = new Utilz(resident, burglar);
        this.bedroom = new Bedroom(utilz, inventory, resident);
        this.kitchen = new Kitchen(utilz, inventory, resident);
        this.office = new Office(utilz, inventory, burglar, resident);
        this.hallway = new Hallway(utilz, inventory, burglar, resident);
    }

    public void gameLoop() {
        utilz.printWelcome();
        String residentName = utilz.userInput();
        resident.setName(residentName);
        utilz.clearConsole();
        System.out.println("Residents name: " + residentName + "\n");
        burglar.setName("Burglar");

        while (running) {
            System.out.println("***You entered the living room***");
            System.out.println("To which room would you like to go? type: \n");
            System.out.println("go to kitchen\ngo to bedroom\ngo to office\ngo to hallway\nor quit");

            String direction = utilz.userInput();
            switch (direction) {
                case "go to kitchen" -> {
                    utilz.clearConsole();
                    kitchen.kitchen();
                }
                case "go to bedroom" -> {
                    utilz.clearConsole();
                    bedroom.bedroom();
                }
                case "go to office" -> {
                    utilz.clearConsole();
                    office.office();
                }
                case "go to hallway" -> {
                    utilz.clearConsole();
                    hallway.hallWay();
                }
                case "quit" -> {
                    System.out.println("Game over!");
                    running = false;
                }
                default -> {
                    utilz.clearConsole();
                    System.out.println("Invalid direction\n");
                }
            }
        }
    }
}
