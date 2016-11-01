package de.jdufner.cleancode.game.take;

import java.util.Scanner;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class HumanPlayer extends AbstractPlayer {

  @Override
  public String getName() {
    return "Human";
  }

  @Override
  public int retrieveMove(int stones) {
    this.stones = stones;
    return retrievePlayerMove();
  }

  private int retrievePlayerMove() {
    do {
      retrieveAndValidateUserInteraction();
    } while (!isValidMove());
    return move;
  }

  private boolean isValidMove() {
    return move >= 1 && move <= 3;
  }

  private void retrieveAndValidateUserInteraction() {
    retrieveUserInteraction();
    validateUserInteraction();
  }

  private void retrieveUserInteraction() {
    System.out.println("Es gibt " + stones + " Steine. Bitte nehmen Sie 1, 2 oder 3!");
    move = new Scanner(System.in).nextInt();
  }

  private void validateUserInteraction() {
    if (!isValidMove()) {
      System.out.println("Falsche Eingabe");
    }
  }

}
