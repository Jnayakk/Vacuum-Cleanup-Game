package game;

import sprites.Sprite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import sprites.Sprite;

public class MapGrid<T> extends Grid<T> {

  private int numRows;
  private int numCols;
  private ArrayList<ArrayList<T>> grid = new ArrayList<ArrayList<T>>();
  private HashMap<Integer, HashMap<Integer, T>> grid1 = new HashMap<Integer, HashMap<Integer, T>>();

  /**
   * Creates a new MapGrid with given number of rows and columns.
   * 
   * @param numRows the number of rows in the grid
   * @param numColumns the number of columns in the grid
   */
  public MapGrid(int numRows, int numColumns) {
    this.numRows = numRows;
    this.numCols = numColumns;
    
    // Dont know how to implement a hashmap representation of grid, so I am making another
    // ArrayList.
    // create another dimension for Arraylist grid.
    for (int i = 0; i < numRows; i++) {
      grid.add(new ArrayList<T>());
    }
    // sets the default value to null
    for (int k = 0; k < numRows; k++) {
      for (int l = 0; l < numColumns; l++) {
        grid.get(k).add(null);
      }
    }

  }

  @Override
  public T getCell(int row, int column) {
    // TODO Auto-generated method stub
    return grid.get(row).get(column);
  }

  @Override
  public void setCell(int row, int column, T item) {
    // TODO Auto-generated method stub
    grid.get(row).set(column, item);
  }

  @Override
  public int getNumRows() {
    // TODO Auto-generated method stub
    return this.numRows;
  }

  @Override
  public int getNumColumns() {
    // TODO Auto-generated method stub
    return this.numCols;
  }


  /**
   * The grid is equal to the other one if it's string representation is also equal
   * 
   * @param other represents another grid to compare with this grid.
   * @return true if grid is equal to another grid, otherwise false
   */
  @Override
  public boolean equals(Grid<T> other) {
    return (this.toString() == other.toString());

  }

  /**
   * Represents a string representation of this <code>MapGrid</code>.
   */
  @Override
  public String toString() {
    String result = "";

    // Convert each sprite in each ArrayList to its string representation, then print it out.
    for (ArrayList<T> list : grid) {
      for (T sprite : list) {
        result += sprite.toString();
      }
      result += "\n";
    }

    return result;
  }

  @Override
  public int hashCode() {
    // TODO Auto-generated method stub
    return 0;
  }

}