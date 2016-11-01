package de.jdufner.cleancode.game.take;

import java.util.Scanner;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class TakeGame implements Game {

  private int stones;
  private Players currentPlayer;
  private static final int MOVES[] = {3, 1, 1, 2};

  private enum Players {
    PLAYER, COMPUTER;
  }

  public TakeGame() {
    stones = 23;
    currentPlayer = Players.PLAYER;
  }

  @Override
  public void play() {
    while(!isGameOver()) {
      doMove();
    }
  }

  private void doMove() {
    if (currentPlayer == Players.PLAYER) {
      playerMove();
    } else {
      computerMove();
    }
  }

  private void playerMove() {
    int move = retrievePlayerMove();
    stones -= move;
    currentPlayer = Players.COMPUTER;
  }

  private int retrievePlayerMove() {
    int move;
    while (true) {
      System.out.println("Es gibt " + stones + " Steine. Bitte nehmen Sie 1, 2 oder 3!");
      move = new Scanner(System.in).nextInt();
      if (move >= 1 && move <= 3) break;
      System.out.println("Falsche Eingabe");
    }
    return move;
  }

  private void computerMove() {
    int move = retrieveComputerMove();
    stones -= move;
    currentPlayer = Players.PLAYER;
  }

  private int retrieveComputerMove() {
    int move = MOVES[stones % 4];
    System.out.println("Ich nehme " +  move + " Steine.");
    return move;
  }

  private boolean isGameOver() {
    return hasLost();
  }

  private boolean hasLost() {
    if (stones <= 0) {
      System.out.println("Der Gewinner ist " + currentPlayer);
      return true;
    }
    return false;
  }

}