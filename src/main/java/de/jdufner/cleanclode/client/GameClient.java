package de.jdufner.cleanclode.client;

import de.jdufner.cleancode.game.Game;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class GameClient {

  private Game game;

  public void setGame(Game game) {
    this.game = game;
  }

  public void run() {
    game.play();
  }

}
