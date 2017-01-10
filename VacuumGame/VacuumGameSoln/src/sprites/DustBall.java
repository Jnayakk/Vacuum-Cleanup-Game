package sprites;

import game.Constants;

/**
 * A Representation of a dustball.
 * 
 * @author Jay
 */

public class DustBall extends Dirt {

  /**
   * Creates a new <code>DustBall</code> with the given row, column and value.
   * 
   * @param row the row of a new <code>DustBall</code>
   * @param column the column of a new <code>DustBall</code>
   * @param value the value of a new <code>DustBall</code>
   */
  public DustBall(int row, int column, int value) {
    super(Constants.DUST_BALL, row, column, value);
  }

  /**
   * Moves this <code>DustBall</code> to the given row and column.
   * 
   * @param row the new row for this <code>DustBall</code>.
   * @param column the new column for this <code>DustBall</code>.
   */
  public void moveTo(int row, int column) {
    this.updateCoordinates(row, column);
  }

}
