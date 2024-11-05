package se.tommy.adventure.utilities;

import se.tommy.adventure.model.Burglar;
import se.tommy.adventure.model.Entity;
import se.tommy.adventure.model.Resident;

import java.util.Scanner;

public class Utilz {


    private Scanner scanner = new Scanner(System.in);
    private Resident resident;
    private Burglar burglar;

    public Utilz(Resident resident, Burglar burglar) {
        this.resident = resident;
        this.burglar = burglar;
    }

    public void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public void printWelcome() {
        System.out.println("Welcome to the Trespasser Game");
        System.out.println("You suddently woke up on your couch in the living room");
        System.out.println("Everything is dark and you can hear someone trying to enter your house\n");
        System.out.println("Enter your name and press enter to continue");
    }

    public String userInput() {
        return scanner.nextLine();
    }

    public void fightOneRound() {
        boolean fightTilUnconcious = true;
        while (fightTilUnconcious && resident.isConcious() && burglar.isConcious()) {

            executeAttack(resident, burglar);
            if (burglar.isConcious()) {
                executeAttack(burglar, resident);
            } else if (!burglar.isConcious() || !resident.isConcious()) {
                fightTilUnconcious = false;
            }
        }
    }

    public void executeAttack(Entity attacker, Entity defender) {

        attacker.punch(defender);
        System.out.println(attacker.getName() + " attacked " + defender.getName() + "\n");

        delay(1000);

        if (defender.isConcious()) {
            System.out.println(defender.getName() + "s health is: " + defender.getHealth() + "\n");
        } else {
            System.out.println("\u001B[31m" + defender.getName() + " is unconcious\n" + "\u001B[0m");
        }

        delay(1000);
    }

    public void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
