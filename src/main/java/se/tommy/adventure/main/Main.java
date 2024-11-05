package se.tommy.adventure.main;

import se.tommy.adventure.logic.Game;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        game.gameLoop();
    }
}
