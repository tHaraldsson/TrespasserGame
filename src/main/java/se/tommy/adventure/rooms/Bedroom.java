package se.tommy.adventure.rooms;

import se.tommy.adventure.inventory.Inventory;
import se.tommy.adventure.model.Resident;
import se.tommy.adventure.utilities.Utilz;

public class Bedroom {

    private Utilz utilz;
    private Inventory inventory;
    private Resident resident;

    public Bedroom(Utilz utilz, Inventory inventory, Resident resident) {
        this.utilz = utilz;
        this.inventory = inventory;
        this.resident = resident;
    }

    public void bedroom() {

        boolean roomRunning = true;
        while (roomRunning) {
            System.out.println("***You entered the bedroom***\n" +
                    "You see your bed\n" +
                    "What would you like to do?\n");
            if (!inventory.isHasPillow()) {
                System.out.println("* Grab a pillow\n" +
                        "* Go to Living room");
            }else{
                System.out.println("* Go to Living room");
            }
            String answer = utilz.userInput();
            utilz.clearConsole();
            if (answer.equalsIgnoreCase("go to living room")) {
                roomRunning = false;
            } else if (answer.equalsIgnoreCase("grab a pillow")) {
                utilz.clearConsole();
                System.out.println("\u001B[44m" + "You are now holding a pillow" + "\u001B[0m\n");
                inventory.setHasPillow(true);
                resident.setDamage(resident.getDamage() + 1);

            } else {
                System.out.println("Invalid input\n");

            }

        }
    }
}
