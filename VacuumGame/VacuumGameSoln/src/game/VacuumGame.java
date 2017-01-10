package game;

import sprites.CleanHallway;
import sprites.Dumpster;
import sprites.Dust;
import sprites.DustBall;
import sprites.Sprite;
import sprites.Vacuum;
import sprites.Wall;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * A Representation of a VacuumGame.
 * 
 * @author Jay
 */

/**
 * A class that represents the basic functionality of the vacuum game. This class is responsible for
 * performing the following operations: 1. At creation, it initializes the instance variables used
 * to store the current state of the game. 2. When a move is specified, it checks if it is a legal
 * move and makes the move if it is legal. 3. It reports information about the current state of the
 * game when asked.
 */
public class VacuumGame {

  private Random random; // a random number generator to move the DustBalls
  private Grid<Sprite> grid; // the grid
  private Vacuum vacuum1; // the first player
  private Vacuum vacuum2; // the second player
  private List<Dust> dusts; // the dusts
  private List<DustBall> dustBalls; // the dust balls

  /**
   * Creates a new <code>VacuumGame</code> that corresponds to the given input text file. Assumes
   * that the input file has one or more lines of equal lengths, and that each character in it
   * (other than newline) is a character that represents one of the <code>Sprite</code>s in this
   * game. Uses gridType to implement the grid.
   * 
   * @param layoutFileName path to the input grid file
   * @param gridType the type of grid implementation to use
   */
  public VacuumGame(String layoutFileName, Constants.GridType gridType) throws IOException {
    dusts = new ArrayList<>();
    dustBalls = new ArrayList<>();
    random = new Random();

    // open the file, read the contents, and determine dimensions of the
    // grid
    int[] dimensions = getDimensions(layoutFileName);
    int numRows = dimensions[0];
    int numColumns = dimensions[1];

    if (gridType.equals(Constants.GridType.LIST_GRID)) {
      grid = new ListGrid<>(numRows, numColumns);
    } else {
      grid = new MapGrid<>(numRows, numColumns);
    }

    // open the file again, read the contents, and store them in grid
    Scanner sc = new Scanner(new File(layoutFileName));

    /********
     * Initialize the grid
     ********/
    // i represents the rows of the grid.
    for (int i = 0; i < dimensions[0]; i++) {
      String nextline = sc.nextLine();
      fillGrid(nextline, i);
    }

    sc.close();
  }

  /**
   * This method fills the grid up with the corresponding sprites according to the given line.
   * 
   * @param line the line that contains all the constants.
   * @param row the row at where to locate the sprites
   */
  private void fillGrid(String line, int row) {

    /*
     * Compares the characters found in the line to the String of the sprites, initializes the
     * sprites and adds them to the array grid. The rows are the numbers given to the method, and
     * the columns are the indexes of the characters in the line.
     */

    for (int i = 0; i < line.length(); i++) {
      char characterAtI = line.charAt(i);

      switch (characterAtI) {

        // If the character at i is a clean constant then create a new
        // CleanHallway class at given row
        // to represent that cell.
        case Constants.CLEAN:
          CleanHallway hall = new CleanHallway(row, i);
          grid.setCell(row, i, hall);
          break;

        // If the character at i is a wall constant then create a new Wall
        // class
        // to represent that cell.
        case Constants.WALL:
          Wall wall = new Wall(row, i);
          grid.setCell(row, i, wall);
          break;

        // If the character at i is a clean constant then create a new
        // CleanHallway class at given
        // row to represent that cell.
        case Constants.DUMPSTER:
          Dumpster dump = new Dumpster(row, i);
          grid.setCell(row, i, dump);
          break;

        // If the character at i is a dust constant then create a new Dust
        // class at given row to
        // represent that cell
        case Constants.DUST:
          Dust dust = new Dust(row, i, Constants.DUST_SCORE);
          grid.setCell(row, i, dust);
          dusts.add(dust);
          break;

        // If the character at i is a dust constant then create a new
        // DustBall class at given row to
        // represent that cell
        case Constants.DUST_BALL:
          DustBall dustBall = new DustBall(row, i, Constants.DUST_BALL_SCORE);
          grid.setCell(row, i, dustBall);
          this.dustBalls.add(dustBall);
          break;
        // If the character at i is a player 1 constant then create a new
        // Vacuum class at given row
        // and capacity to represent that cell
        case Constants.P1:
          vacuum1 = new Vacuum(Constants.P1, row, i, Constants.CAPACITY);
          CleanHallway cleanHall = new CleanHallway(row, i);
          vacuum1.setUnder(cleanHall);
          this.grid.setCell(row, i, vacuum1);
          break;

        // Lastly If the character at i is a player 2 constant then create a
        // new Vacuum class at given row
        // and capacity to represent that cell
        case Constants.P2:
          vacuum2 = new Vacuum(Constants.P2, row, i, Constants.CAPACITY);
          CleanHallway cleanHall1 = new CleanHallway(row, i);
          vacuum2.setUnder(cleanHall1);
          this.grid.setCell(row, i, vacuum2);
          break;
        default:
          break;
      }

    }

  }

  /**
   * Returns the grid of this <code>VacuumGame</code>.
   * 
   * @return the grid of the game <code>VacuumGame</code>.
   */
  public Grid<Sprite> getGrid() {
    return this.grid;
  }

  /**
   * Returns the first player in this <code>VacuumGame</code>.
   * 
   * @return vacuum one in this <code>VacuumGame</code>.
   */
  public Vacuum getVacuumOne() {
    return this.vacuum1;

  }

  /**
   * Returns the second player in this <code>VacuumGame</code>.
   * 
   * @return vacuum two in this <code>VacuumGame</code>.
   */
  public Vacuum getVacuumTwo() {
    return this.vacuum2;
  }

  /**
   * Returns the number of rows in the grid of this <code>VacuumGame</code>.
   * 
   * @return the number of rows of this game's grid.
   */
  public int getNumRows() {
    return this.grid.getNumRows();
  }

  /**
   * Returns the number of columns in the grid of this <code>VacuumGame</code>.
   * 
   * @return the number of columns of this game's grid.
   */
  public int getNumColumns() {
    return this.grid.getNumColumns();
  }

  /**
   * Returns true if the next move is valid when the direction is entered and moves to that
   * position, otherwise returns false. if the next move is not valid.
   * 
   * @param nextMove the next move given by the user.
   * @return true is nextMove is valid, false otherwise.
   */
  public boolean move(char nextMove) {

    // Call the tryToMove method to see if we are able to move the vacuums.
    switch (nextMove) {

      // Player One moves
      case Constants.P1_UP:
        return this.tryToMove(vacuum1, Constants.UP, 0);
      case Constants.P1_DOWN:
        return this.tryToMove(vacuum1, Constants.DOWN, 0);
      case Constants.P1_LEFT:
        return this.tryToMove(vacuum1, 0, Constants.LEFT);
      case Constants.P1_RIGHT:

        // Player Two Moves
        return this.tryToMove(vacuum1, 0, Constants.RIGHT);
      case Constants.P2_UP:
        return this.tryToMove(vacuum2, Constants.UP, 0);
      case Constants.P2_DOWN:
        return this.tryToMove(vacuum2, Constants.DOWN, 0);
      case Constants.P2_LEFT:
        return this.tryToMove(vacuum2, 0, Constants.LEFT);
      case Constants.P2_RIGHT:
        return this.tryToMove(vacuum2, 0, Constants.RIGHT);
      default:
        break;
    }
    // this.moveDustBall();
    return false;
  }


  /**
   * Returns true if the vacuum is able to move, false if not.
   * 
   * @param vacuum the given vacuum to move.
   * @param newRow the new row to move to.
   * @param newColumn the new column to move to.
   * @return true if the vacuum is able to move, false if not.
   */
  private boolean tryToMove(Vacuum vacuum, int newRow, int newColumn) {
    // Save the old coordinates incase the vacuum is unable to clean the
    // sprite.
    Integer[] oldCoordinates = {vacuum.getRow(), vacuum.getColumn()};
    // Declare the new coordinates to be where the vacuum will move.
    Integer[] newCoordinates = {vacuum.getRow() + newRow, vacuum.getColumn() + newColumn};

    // Declaring variables for the constants DUST_BALL_SCORE and DUST_SCORE
    int dustballScore = Constants.DUST_BALL_SCORE;
    int dustScore = Constants.DUST_SCORE;

    // If the given coordinates is a valid
    if (validVacuumSpace(newCoordinates[0], newCoordinates[1])) {

      // Set currentsprite to whatever sprite is underneath the vacuum
      // right now.
      final Sprite oldSprite = vacuum.getUnder();

      // Move to the new coordinates and set whatever is underneath the
      // vacuum to newSprite.
      vacuum.moveTo(newCoordinates[0], newCoordinates[1]);
      Sprite newSprite = this.getSprite(newCoordinates[0], newCoordinates[1]);
      vacuum.setUnder(newSprite);
      this.grid.setCell(newCoordinates[0], newCoordinates[1], vacuum);

      /*
       * If the new sprite is a DustBall and can be cleaned, then remove this new sprite from
       * dustBalls array.
       */
      if ((newSprite.getSymbol() == Constants.DUST_BALL) && (vacuum.clean(dustballScore))) {
        this.dustBalls.remove(newSprite);


        /*
         * If the new sprite is a Dust and can be cleaned, then remove this new sprite from dusts
         * array.
         */
      } else if ((newSprite.getSymbol() == Constants.DUST) && (vacuum.clean(dustScore))) {
        this.dusts.remove(newSprite);


        // Empty the vacuum if the new sprite is a dumpster.
      } else if (newSprite.getSymbol() == Constants.DUMPSTER) {
        vacuum.empty();
      }

      // if the new sprite is not a dust/dustball/dumpster or the vacuum
      // can not
      // clean the dust/dustball, set the previous sprite that was under
      // the vacuum
      // at the old coordinates meaning it has not been cleaned.
      this.grid.setCell(oldCoordinates[0], oldCoordinates[1], oldSprite);
    }

    // no matter whether the vacuum moves or not, move all the dustballs.
    this.moveDustBall();
    return true;
  }

  /**
   * Returns the sprite located at the given row and column.
   * 
   * @param row The row location of the sprite being returned.
   * @param column The column location of the sprite being returned.
   * @return the sprite at location (i,k).
   */
  public Sprite getSprite(int row, int column) {
    return this.grid.getCell(row, column);
  }

  /**
   * Returns a random direction at which the dustball is able to move to.
   * 
   * @param dustBall the dustball that is going to move in this <code>VacuumGame</code>.
   * @param row the row where the dustball is located in this <code>VacuumGame</code>.
   * @param column the column where the dustball is located in this <code>VacuumGame</code>.
   * @return a random valid direction that the dustball can move to.
   */
  private Integer[] randDustBallMove(DustBall dustBall, int row, int column) {
    // All of the possible random directions the dustball can move to.
    Integer[] goUp = {row + Constants.UP, column};
    Integer[] goLeft = {row, column + Constants.LEFT};
    Integer[] goRight = {row + Constants.DOWN, column};
    Integer[] goDown = {row, column + Constants.RIGHT};

    // Create an array containing all of the possible directions.
    Integer[][] directions = {goUp, goLeft, goRight, goDown};
    ArrayList<Integer[]> randomDirections = new ArrayList<Integer[]>(Arrays.asList(directions));

    // From the array pick one random direction to go to.
    Integer[] dustballDirection = randomDirections.get(random.nextInt(randomDirections.size()));

    // while the chosen direction to move in is not valid, remove the
    // invalid possible directions
    while (!validDustballMove((dustballDirection)[0], dustballDirection[1])) {
      randomDirections.remove(dustballDirection);

      // Choose a random direction to move in from the remaining valid
      // directions.
      if (!randomDirections.isEmpty()) {
        dustballDirection = randomDirections.get(random.nextInt(randomDirections.size()));
      } else {
        return null;
      }
    }
    return dustballDirection;
  }

  /**
   * Moves the Dust Ball to a random direction, given that the direction is valid, it will also
   * leave a trail of dirt behind it as it moves.
   */
  private void moveDustBall() {

    for (java.util.Iterator<DustBall> it = dustBalls.iterator(); it.hasNext();) {
      DustBall dustBall = it.next();
      int row = dustBall.getRow();
      int column = dustBall.getColumn();
      // Get
      Integer[] move = randDustBallMove(dustBall, row, column);

      // if there are still valid moves left.
      if (move != null) {
        // Move to the new position
        dustBall.moveTo(move[0], move[1]);

        // if this new position has dirt on it, eat it up.
        Sprite newSprite = this.getSprite(move[0], move[1]);
        if ((newSprite.getSymbol() == Constants.DUST)) {
          dusts.remove(newSprite);
        }
        this.grid.setCell(move[0], move[1], dustBall);
        Sprite oldSprite = this.getSprite(row, column);
        Dust dust = new Dust(row, column, Constants.CAPACITY);

        // if the previous position has a vacuum on it, put the dirt
        // underneath the vacuum.
        if ((oldSprite.getSymbol() == Constants.P1) || (oldSprite.getSymbol() == Constants.P2)) {
          ((Vacuum) oldSprite).setUnder(dust);
        }

        // leave dirt behind so it becomes a trail of dirt.
        else {
          dusts.add(dust);
          this.grid.setCell(row, column, dust);
        }
      }
    }
  }

  /**
   * Given the row and column to where the vacuum wants to move to, it checks if the sprite is not a
   * wall or anything that will not allow it to move there.
   * 
   * @param row the row where the vacuum will move.
   * @param column the column where the vacuum will move.
   * @return true if the sprite where the vacuum wants to move is either a dust, dustball, dumpster
   *         or clean space, and returns false otherwise.
   */
  private boolean validVacuumSpace(int row, int column) {
    Sprite sprite = this.getSprite(row, column);
    return ((sprite.getSymbol() == Constants.DUST) || (sprite.getSymbol() == Constants.DUST_BALL)
        || (sprite.getSymbol() == Constants.CLEAN) || (sprite.getSymbol() == Constants.DUMPSTER));
  }

  /**
   * Given the row and column to where the dustball wants to move to, it checks if the sprite is a
   * clean space or dust so that it can move there.
   * 
   * @param row the row where the dustball will move.
   * @param column the column where the dustball will move.
   * @return true if the sprite where the vacuum wants to move is either a dust, dustball, dumpster
   *         or clean space, and returns false otherwise.
   */
  private boolean validDustballMove(int row, int column) {
    Sprite sprite = this.getSprite(row, column);
    return ((sprite.getSymbol() == Constants.DUST) || (sprite.getSymbol() == Constants.CLEAN));
  }

  /**
   * Returns true if the game is over meaning all the dusts and dustballs have been collected, false
   * otherwise.
   * 
   * @return true if and only if the game is over.
   */
  public boolean gameOver() {
    return ((dusts.isEmpty()) && (dustBalls.isEmpty()));
  }

  /**
   * Returns 1 is the first player won the game, 2 if the second player won the game, and 0 if the
   * game ended in a tie.
   * 
   * @return 1 if vacuum 1 wins, 2 is vacuum 2 wins, 0 otherwise.
   */
  public char getWinner() {
    if (vacuum1.getScore() > vacuum2.getScore()) {
      return Constants.P1;
    } else if (vacuum1.getScore() < vacuum2.getScore()) {
      return Constants.P2;
    } else {
      return 0;
    }
  }

  /**
   * Returns the dimensions of the grid in the file named layoutFileName.
   * 
   * @param layoutFileName path of the input grid file
   * @return an array [numRows, numCols], where numRows is the number of rows and numCols is the
   *         number of columns in the grid that corresponds to the given input grid file
   * @throws IOException if cannot open file layoutFileName
   */
  private int[] getDimensions(String layoutFileName) throws IOException {

    Scanner sc = new Scanner(new File(layoutFileName));

    // find the number of columns
    String nextLine = sc.nextLine();
    int numCols = nextLine.length();

    // find the number of rows
    int numRows = 1;
    while (sc.hasNext()) {
      numRows++;
      nextLine = sc.nextLine();
    }

    sc.close();
    return new int[] {numRows, numCols};
  }
}
