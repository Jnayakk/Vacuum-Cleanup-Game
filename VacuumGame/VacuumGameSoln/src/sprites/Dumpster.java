package sprites;

import game.Constants;

/**
 * A Representation of a dumpster.
 * 
 * @author Jil
 */
public class Dumpster extends Sprite {

  /**
   * Creates a new <code>Dumpster</code> with the given row and column.
   * 
   * @param row the row of a new <code>Dumpster</code>
   * @param column the column of a new <code>Dumpster</code>
   */
  public Dumpster(int row, int column) {
    super(Constants.DUMPSTER, row, column);
  }

}
