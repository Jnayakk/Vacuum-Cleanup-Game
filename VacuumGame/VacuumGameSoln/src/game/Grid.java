package game;

import java.util.ArrayList;

/**
 * A representation of a grid.
 * 
 * @author Jay
 */
public abstract class Grid<T> {

  /**
   * An abstract method to get a cell of this <code>Grid</code>.
   * 
   * @param row the row of a new <code>Grid</code>.
   * @param column the column of a new <code>Grid</code>.
   */
  public abstract T getCell(int row, int column);

  /**
   * An abstract method to set the cell of this <code>Grid</code> to given item at given row and
   * column.
   * 
   * @param row the row of a new <code>Grid</code>.
   * @param column the column of a new <code>Grid</code>.
   * @param item the item of a new <code>Grid</code>.
   */
  public abstract void setCell(int row, int column, T item);

  /**
   * An abstract method to get the number of rows of this <code>Grid</code>.
   */
  public abstract int getNumRows();

  /**
   * An abstract method to get the number of columns of this <code>Grid</code>.
   */
  public abstract int getNumColumns();

  @Override
  public abstract int hashCode();

  /**
   * Represents a string representation of this <code>Grid</code>.
   */
  @Override
  public String toString() {
    String result = "";

    // Convert each sprite in each ArrayList to its string representation, then print it out.
    for (ArrayList<T> list : new ArrayList<ArrayList<T>>()) {
      for (T sprite : list) {
        result += sprite.toString();
      }
      result += "\n";
    }

    return result;
  }

  /**
   * The grid is equal to the other one if it's string representation is also equal
   * 
   * @param other represents another grid to compare with this grid.
   * @return true if grid is equal to another grid, otherwise false
   */
  public boolean equals(Grid<T> other) {
    // TODO Auto-generated method stub
    return this.toString() == other.toString();
  }

}
