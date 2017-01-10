

package sprites;

import game.Constants;

/**
 * A representation of a wall.
 * 
 * @author Jil
 */
public class Wall extends Sprite {

  /**
   * Creates a new <code>Wall</code> with the given row and column.
   * 
   * @param row the row of a new <code>Wall</code>
   * @param column the column of a new <code>Wall</code>
   */
  public Wall(int row, int column) {
    super(Constants.WALL, row, column);
  }

}
