package sprites;

/**
 * A Representation of a Dirt.
 * 
 * @author Jay
 */

public abstract class Dirt extends Sprite {

  private int value; // The value of the Dirt.

  /**
   * Creates a new <code>Dirt</code> with the given symbol, row, column and value.
   * 
   * @param symbol the symbol representing a new <code>Dirt</code>
   * @param row the row of a new <code>Dirt</code>
   * @param column the column of a new <code>Dirt</code>
   * @param value the value of a new <code>Dirt</code>
   */
  public Dirt(char symbol, int row, int column, int value) {
    super(symbol, row, column);
    this.value = value;

  }

  /**
   * Returns the value of this <code>Dirt</code>.
   * 
   * @return the value of this <code>Dirt</code>.
   */
  public int getValue() {
    return value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + value;
    return result;
  }

  @Override
  /**
   * Returns true if this <code>Dirt</code> is equal to another <code>Dirt</code>.
   * 
   * @return true if this <code>Dirt</code> is equal to another <code>Dirt</code>.
   */
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Dirt other = (Dirt) obj;
    return value == other.value;
  }

}
