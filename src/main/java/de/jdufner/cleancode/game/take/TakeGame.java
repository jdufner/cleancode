package de.jdufner.cleancode.game.take;

import java.util.Scanner;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class TakeGame implements Game {

  private int stones;
  private int move;
  private AbstractPlayer human = new HumanPlayer();
  private AbstractPlayer computer = new ComputerPlayer();
  private AbstractPlayer currentPlayer;

  public TakeGame() {
    stones = 23;
    currentPlayer = human;
  }

  @Override
  public void play() {
    while(!isGameOver()) {
      doMove();
    }
  }

  private void doMove() {
    move = currentPlayer.retrieveMove(stones);
    stones -= move;
    currentPlayer = determineNextPlayer();
  }

  private AbstractPlayer determineNextPlayer() {
    if (currentPlayer == human) {
      return computer;
    } else {
      return human;
    }
  }

  private boolean isGameOver() {
    return hasLost();
  }

  private boolean hasLost() {
    if (stones <= 0) {
      System.out.println("Der Gewinner ist " + currentPlayer.getName());
      return true;
    }
    return false;
  }

}