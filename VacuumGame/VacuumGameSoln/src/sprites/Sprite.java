/**
 * 
 */

package sprites;

/**
 * A representation of a sprite.
 * 
 * @author Jay
 */
public abstract class Sprite {

  private char symbol; // The symbol of the sprite.
  private int row; // The row at where the sprite is located.
  private int column; // The column at where the sprite is located.

  /**
   * Creates a new <code>Sprite</code> with the given symbol, row and column.
   * 
   * @param symbol the symbol representing a new <code>Sprite</code>
   * @param row the row of a new <code>Sprite</code>
   * @param column the column of a new <code>Sprite</code>
   */
  public Sprite(char symbol, int row, int column) {
    this.symbol = symbol;
    this.row = row;
    this.column = column;
  }

  /**
   * Returns the symbol of this <code>Sprite</code>.
   * 
   * @return the symbol of this <code>Sprite</code>.
   */
  public char getSymbol() {
    return symbol;
  }

  /**
   * Returns the row of this <code>Sprite</code>.
   * 
   * @return the row of this <code>Sprite</code>.
   */
  public int getRow() {
    return row;
  }

  /**
   * Returns the column of this <code>Sprite</code>.
   * 
   * @return the column of this <code>Sprite</code>.
   */
  public int getColumn() {
    return column;
  }

  /**
   * Updates the coordinates of this <code>Sprite</code> to the given row and column.
   * 
   * @param row the new row for this <code>Sprite</code>.
   * @param column the new column for this <code>Sprite</code>.
   */
  protected void updateCoordinates(int row, int column) {
    this.row = row;
    this.column = column;
  }

  @Override
  public String toString() {
    return Character.toString(getSymbol());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + column;
    result = prime * result + row;
    result = prime * result + symbol;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Sprite other = (Sprite) obj;
    return symbol == other.symbol && row == other.row && column == other.column;
  }

}
