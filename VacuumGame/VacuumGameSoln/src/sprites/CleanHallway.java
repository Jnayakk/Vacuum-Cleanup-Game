package sprites;

import game.Constants;

/**
 * A Representation of a clean hallway.
 * 
 * @author Jay
 */
public class CleanHallway extends Sprite {

  /**
   * Creates a new <code>CleanHallway</code> with the given row and column.
   * 
   * @param row the row of a new <code>CleanHallway</code>
   * @param column the column of a new <code>CleanHallway</code>
   */
  public CleanHallway(int row, int column) {
    super(Constants.CLEAN, row, column);
  }

}
