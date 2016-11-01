package de.jdufner.cleancode.game.take;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public abstract class AbstractPlayer {

  int stones;
  int move;

  public abstract String getName();

  public abstract int retrieveMove(int stones);

}
