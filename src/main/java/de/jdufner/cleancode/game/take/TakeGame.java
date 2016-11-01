package de.jdufner.cleancode.game.take;

import java.util.Scanner;

/**
 * @author Jürgen Dufner
 * @since 1.0
 */
public class TakeGame implements Game {

  private Scanner scanner = new Scanner(System.in);
  private int[] MOVES = {3, 1, 1, 2};
  private int stones;
  private boolean gameover;

  public TakeGame() {
    stones = 23;
    gameover = false;
  }

  @Override
  public void play() {
    while (!gameover) {
      playerMove();
      computerMove();
    }
  }

  private void playerMove() {
    int move;
    while (true) {
      System.out.println("Der aktuelle Spielstand ist " + stones + " Steine. Geben Sie eine Zahl 1, 2, 3 ein.");
      move = scanner.nextInt();
      if (move >= 1 && move <= 3) break;
      System.out.println("Falsche Eingabe.");
    }
    stones -= move;
  }

  private void computerMove() {
    if (stones <= 0) {
      gameover = true;
      System.out.println("Loser!");
      return;
    }
    if (stones == 1) {
      gameover = true;
      System.out.println("Glückwunsch. Sie haben gewonnen");
      return;
    }
    int move = MOVES[stones % 4];
    System.out.println("Ich nehme " + move + " Steine.");
    stones -= move;
  }

}
