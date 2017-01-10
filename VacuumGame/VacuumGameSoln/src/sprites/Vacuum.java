package sprites;

import game.Constants;

/**
 * A representation of a Vacuum.
 * 
 * @author Jay
 */
public class Vacuum extends Sprite {

  private int score; // The score of the vacuum.
  private int capacity; // The capacity of dust and dustballs that the vacuum can contain.
  private int fullness; // The amount of dust and dustballs that are currently in the vacuum.
  private Sprite under; // The stuff underneath the vacuum.

  /**
   * Creates a new <code>Vacuum</code> with the given symbol, row, column and capacity.
   * 
   * @param symbol the symbol representing a new <code>Vacuum</code>
   * @param row the row of a new <code>Vacuum</code>
   * @param column the column of a new <code>Vacuum</code>
   * @param capacity the capacity of a new <code>Vacuum</code>
   */
  public Vacuum(char symbol, int row, int column, int capacity) {
    super(symbol, row, column);
    this.capacity = capacity;
    this.fullness = Constants.EMPTY;
    this.score = Constants.INIT_SCORE;
  }

  /**
   * Moves this <code>Vacuum</code> to the given row and column.
   * 
   * @param row the new row for this <code>Vacuum</code>.
   * @param column the new column for this <code>Vacuum</code>.
   */
  public void moveTo(int row, int column) {
    this.updateCoordinates(row, column);
  }

  /**
   * Empties up this <code>Vacuum</code> by clearing it's fullness.
   */
  public void empty() {
    fullness = Constants.EMPTY;
  }

  /**
   * Sets the given sprite under this <code>Vacuum</code>.
   * 
   * @param under the sprite under this <code>Vacuum</code>.
   */
  public void setUnder(Sprite under) {
    this.under = under;
  }

  /**
   * Returns what is underneath this <code>Vacuum</code>.
   * 
   * @return what is underneath this this <code>Vacuum</code>.
   */
  public Sprite getUnder() {
    return under;
  }

  /**
   * Returns true if the clean was success full and false if it was not.
   * 
   * @param score the score of the vacuum
   * @return true if the clean is success full and false if it is not.
   */
  public boolean clean(int score) {
    // If the vacuum is not yet full, add the score and fullness to whatever
    // it sucks up.
    if (fullness < this.capacity) {
      this.under = new CleanHallway(this.getRow(), this.getColumn());
      this.score += score;
      fullness += 1;
      return true;
    }
    return false;
  }

  /**
   * Returns the score of this <code>Vacuum</code>.
   * 
   * @return the score of this <code>Vacuum</code>.
   */
  public int getScore() {
    return this.score;
  }

}
