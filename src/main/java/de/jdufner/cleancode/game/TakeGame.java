package de.jdufner.cleancode.game;

import java.util.Scanner;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class TakeGame implements Game {

  private int[] MOVES = {3, 1, 1, 2};
  private int stones;
  private boolean gameover;

  public TakeGame() {
    stones = 23;
    gameover = false;
  }

  public void play() {
    while (!gameover) {
      playerMove();
      computerMove();
    }
  }

  private void playerMove() {
    int move;
    while (true) {
      System.out.println("Der aktuelle Spielstand ist " + stones + ". Geben Sie eine Zahl 1, 2, 3 ein.");
      move = new Scanner(System.in).nextInt();
      if (move >= 1 && move <= 3) break;
    }
    stones -= move;
  }

  private void computerMove() {
    if (stones == 1) {
      gameover = true;
      System.out.println("Glückwunsch. Sie haben gewonnen");
      return;
    }
    if (stones <= 0) {
      gameover = true;
      System.out.println("Loser!");
    }
    stones -= MOVES[stones % 4];
  }

}
