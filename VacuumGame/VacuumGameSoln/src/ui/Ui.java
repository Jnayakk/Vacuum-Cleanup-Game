package ui;

import java.io.IOException;

/**
 * The UI interface for handling front-end.
 * 
 * @author Jil Nayak
 *
 */
public interface Ui {

  /**
   * Launches the game of the selected UI.
   * 
   * @throws IOException throws an ioexception.
   */
  public void launchGame() throws IOException;

  /**
   * Displays the end message once game ends.
   */
  public void displayWinner();
}
