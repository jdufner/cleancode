package de.jdufner.cleancode.game.take;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class ComputerPlayer extends AbstractPlayer {

  private static final int MOVES[] = {3, 1, 1, 2};

  @Override
  public String getName() {
    return "Computer";
  }

  @Override
  public int retrieveMove(int stones) {
    this.stones = stones;
    return retrieveComputerMove();
  }

  private int retrieveComputerMove() {
    int move = MOVES[stones % 4];
    System.out.println("Ich nehme " + move + " Steine.");
    return move;
  }

}
