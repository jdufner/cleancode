package de.jdufner.cleancode.game.application;

import de.jdufner.cleancode.game.client.GameClient;
import de.jdufner.cleancode.game.take.Game;
import de.jdufner.cleancode.game.take.TakeGame;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class Main {

  public static void main(String[] args) {
    Game game = new TakeGame();
    GameClient client = new GameClient();
    client.setGame(game);
    client.run();
  }

}
