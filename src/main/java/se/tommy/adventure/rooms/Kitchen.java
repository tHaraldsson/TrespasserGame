package se.tommy.adventure.rooms;

import se.tommy.adventure.inventory.Inventory;
import se.tommy.adventure.model.Resident;
import se.tommy.adventure.utilities.Utilz;

public class Kitchen {

    private Utilz utilz;
    private Inventory inventory;
    private Resident resident;

    public Kitchen(Utilz utilz, Inventory inventory, Resident resident) {
        this.utilz = utilz;
        this.inventory = inventory;
        this.resident = resident;
    }

    public void kitchen() {

        boolean roomRunning = true;
        while (roomRunning) {
            System.out.println("***You entered the kitchen***\n" +
                    "You see some kitchen utensils\n" +
                    "What would you like to do?\n");
            if (!inventory.isHasFryingPan()) {
                System.out.println("* Grab a frying pan\n" +
                        "* Go to Living room");
            }else{
                System.out.println("* Go to Living room");
            }
            String answer = utilz.userInput();
            utilz.clearConsole();
            if (answer.equalsIgnoreCase("go to living room")) {
                roomRunning = false;
            } else if (answer.equalsIgnoreCase("grab a frying pan")) {
                utilz.clearConsole();
                System.out.println("\u001B[44m" + "You are now holding a frying pan" + "\u001B[0m\n");
                inventory.setHasFryingPan(true);
                resident.setDamage(resident.getDamage() + 4);

            } else {
                System.out.println("Invalid input\n");
            }
        }
    }
}
