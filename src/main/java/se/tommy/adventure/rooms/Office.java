package se.tommy.adventure.rooms;

import se.tommy.adventure.inventory.Inventory;
import se.tommy.adventure.model.Burglar;
import se.tommy.adventure.model.Resident;
import se.tommy.adventure.utilities.Utilz;

import static se.tommy.adventure.logic.Game.running;

public class Office {
    private Utilz utilz;
    private Inventory inventory;
    private Burglar burglar;
    private Resident resident;

    public Office(Utilz utilz, Inventory inventory, Burglar burglar, Resident resident) {
        this.utilz = utilz;
        this.inventory = inventory;
        this.burglar = burglar;
        this.resident = resident;
    }

    public void office() {

        boolean roomRunning = true;
        while (roomRunning) {
            System.out.println("***You entered the office***\n" +
                    "You see your phone\n" +
                    "What would you like to do?\n");

            System.out.println("* Go to Living room\n" +
                    "* Call for help");

            String answer = utilz.userInput();
            utilz.clearConsole();
            if (answer.equalsIgnoreCase("go to living room")) {
                roomRunning = false;
            } else if (answer.equalsIgnoreCase("call for help")) {
                if (burglar.isConcious()) {
                    System.out.println("\u001B[31m" + "The burglar is conscious. He grabs the phone and starts a fight with you" + "\u001B[0m\n");
                    utilz.fightOneRound();
                    if (!resident.isConcious()) {
                        System.out.println("\n" +
                                "The burglar has knocked you unconcious and stole all your stuff!!\n" +
                                "GAME OVER!!!");
                        roomRunning = false;
                        running = false;
                    } else if (!burglar.isConcious()) {
                        System.out.println("The burglar is unconcious, you make a call to the police\n" +
                                "and get to safety");
                        roomRunning = false;
                        running = false;
                    }
                } else if (!burglar.isConcious()) {
                    System.out.println("The burglar is unconcious, you make a call to the police\n" +
                            "and get to safety");
                    roomRunning = false;
                    running = false;
                } else {
                    System.out.println("Invalid input\n");
                }
            }else {
                System.out.println("Invalid input\n");
            }
        }
    }
}
