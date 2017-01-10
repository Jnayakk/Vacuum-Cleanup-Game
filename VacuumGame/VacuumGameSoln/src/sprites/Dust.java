package sprites;

import game.Constants;

/**
 * A Representation of a dust.
 * 
 * @author Jil
 */

public class Dust extends Dirt {

  /**
   * Creates a new <code>Dust</code> with the given row, column and value.
   * 
   * @param row the row of a new <code>Dust</code>
   * @param column the column of a new <code>Dust</code>
   * @param value the value of a new <code>Dust</code>
   */
  public Dust(int row, int column, int value) {
    super(Constants.DUST, row, column, value);
  }

}
