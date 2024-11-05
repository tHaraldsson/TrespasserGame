package se.tommy.adventure.rooms;

import se.tommy.adventure.inventory.Inventory;
import se.tommy.adventure.model.Burglar;
import se.tommy.adventure.model.Resident;
import se.tommy.adventure.utilities.Utilz;

import static se.tommy.adventure.logic.Game.running;

public class Hallway {

    private Utilz utilz;
    private Inventory inventory;
    private Burglar burglar;
    private Resident resident;

    public Hallway(Utilz utilz, Inventory inventory, Burglar burglar, Resident resident) {
        this.utilz = utilz;
        this.inventory = inventory;
        this.burglar = burglar;
        this.resident = resident;
    }

    public void hallWay() {

        boolean roomRunning = true;
        while (roomRunning) {

            if (!burglar.isConcious()) {
                System.out.println("***You entered the hallway***\n" +
                        "What would you like to do?\n" +
                        "* Go to living room");
            } else {

                System.out.println("***You entered the hallway***\n" +
                        "You see the burglar\n" +
                        "What would you like to do?\n");

                System.out.println("* Go to living room\n" +
                        "* Fight the burglar");
            }
            String answer = utilz.userInput();
            utilz.clearConsole();
            if (answer.equalsIgnoreCase("go to living room")) {
                roomRunning = false;
            } else if (answer.equalsIgnoreCase("fight the burglar")) {
                utilz.fightOneRound();
                if (!resident.isConcious()) {
                    System.out.println("You are unconcious and the burglar stole all your stuff\n" +
                            "Game over!!");
                    roomRunning = false;
                    running = false;
                } else if (!burglar.isConcious()) {
                    System.out.println("\u001B[32m" + "You fought the burglar and he is now unconscious\n" + "\u001B[0m");
                }
            } else {
                System.out.println("Invalid input\n");
            }
        }
    }
}
