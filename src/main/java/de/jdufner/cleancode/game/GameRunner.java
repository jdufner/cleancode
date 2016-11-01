package de.jdufner.cleancode.game;

import de.jdufner.cleanclode.client.GameClient;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class GameRunner {

  public static void main(String[] args) {
    Game game = new TakeGame();

    GameClient client = new GameClient();
    client.setGame(game);
    client.run();
  }

}
