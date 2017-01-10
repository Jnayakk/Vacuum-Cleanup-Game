package ui;

import game.Constants;
import game.VacuumGame;
import sprites.Vacuum;

import java.io.IOException;
import java.util.Scanner;



/**
 * A TextUI object representation of The great vacuum race game.
 * 
 * @author Jil Nayak
 */
public class TextUi implements Ui {

  private VacuumGame game;

  /**
   * Creates a new TextUI object with a particular game as its instance variable.
   * 
   * @param game The game object to work with
   */
  public TextUi(VacuumGame game) {
    this.game = game;
  }

  /**
   * Launches the game of this object, asks for the user's move and updates accordingly.
   */
  @Override
  public void launchGame() throws IOException {
    while (true) {
      // Prins the grid
      System.out.println(this.game.getGrid().toString());
      System.out.println("Your next move:");

      @SuppressWarnings("resource")
      Scanner input = new Scanner(System.in); // Ask user for input

      // Moves according to the user input
      char userInput = input.nextLine().charAt(0);
      this.game.move(userInput);
      int winner = this.game.getWinner(); // Checks if there is a winner
      
      // If a winner has been declared or the game has ended in a tie, break out of function
      // other wise, ask for a user input again.
      if (winner == Constants.P1 || winner == Constants.P2 || winner == Constants.TIE) {
        break;
      } else {
        input.reset();
      }

    }
  }

  /**
   * Shows a message on the screen when the game has ended.
   * 
   */
  @Override
  public void displayWinner() {
    // Almost the same as Gui.java except print message.
    if (!game.gameOver()) {
      return;
    }
    char won = game.getWinner();
    String message;
    if (won == Constants.TIE) {
      message = "It's a tie!";
    } else {
      Vacuum winner = (won == Constants.P1) ? game.getVacuumOne() : game.getVacuumTwo();
      int score = winner.getScore();
      message = String.format("Congratulations Player %s! You won the game with a score of %d.",
          winner.toString(), score);
    }
    System.out.println(message);
  }
}
