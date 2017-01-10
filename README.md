# The Vacuum Cleanup Game
A two player game where the objective is to end up with the most points by cleaning up all of the dust and dustballs.

## Description
The game board is a 2-dimensional grid. Each cell in this grid represents either a section of hallway, a piece of wall, or a dumpster. There are two players in this game — two vacuums. Some of the cells are dirty: they contain dirt or dustballs. The vacuums’ objective is to clean up as many dirty cells as possible. The dirt is stationary, but the dustballs move about the grid and each cell that a dustball visits becomes dirty (if it wasn’t already) when the dustball leaves. The image below shows the initial state of the vacuum game. Notice the first player seen as '1', the second player seen as '2', 16 dirty cells represented by '.', four dustballs 'o', three dumpsters 'U', and the walls represented by 'X'.

### The initial state of the game.
![initialstate](https://cloud.githubusercontent.com/assets/24378046/21819933/bc8afa18-d73b-11e6-9c52-142c6b04529d.png)

Vacuum 1 moves left when the user presses the 'a' key, moves right on the 'd' key, moves up on the 'w' key and moves down on the 's' key. Similarly, vacuum 2 moves left on the 'j' key, moves right on the 'l' key, moves up on the 'i' key and moves down on the 'k' key.

A vacuum cannot move onto the other vacuum (or a wall, of course), but can move onto dirt, a dust ball, a dumpster (or clean hallway, of course). After a vacuum moves, if there are dustballs, they move randomly.

Each time a vacuum cleans dirt, the vacuum’s score is incremented; the vacuum earns 1 point for cleaning a dirt, and 2 points for cleaning a dustball.

### The middle of the game where both player 1 and 2 are trying to collect as many dust and dustballs as possible.
![middlegame](https://cloud.githubusercontent.com/assets/24378046/21819938/c06395a0-d73b-11e6-8b5d-d369a820b12a.png)

Each vacuum has a capacity. Cleaning up dirt or a dustball adds a constant amount to the fullness of the vacuum. When a vacuum becomes full, it cannot clean any more dirt; it can still go to dirty hallways, but it has no effect on the dirt that is there. A vacuum that enters a cell with a dumpster is emptied (i.e., it has zero fullness); thus, if a vacuum is full, in order to resume cleaning dirt, it must visit a dumpster. Dumpsters have no limit on their capacity. The game ends when all dirt (including dustballs) is gone. The vacuum with the higher score wins, or, if the two scores are equal, we declare a tie.

### In this case, since player two collected more dust and dustballs, they have a score of 42 and win.
![ku1f7pc5x](https://cloud.githubusercontent.com/assets/24378046/21819946/c5faaeae-d73b-11e6-892b-013a4b3cbb0d.png)

![congratsmsg](https://cloud.githubusercontent.com/assets/24378046/21819949/c8b6c40c-d73b-11e6-899e-f78fc5d995ea.png)

## How the Grid works.
The game is played on a grid where each character represents a component in the game. For example, the character 'X' represents a wall, '1' represents player 1, '2' represents player 2, '.' represents dust, 'o' represents dustballs, 'U' represents a dumpster, and of course ' ' the blank space represents an empty space that contains no dust or dustballs. To get each grid, there is a method called fill grid in VacuumGame.java which reads the characters from a textfile and then populates the grid according to the textfile. For example a sample textfile where the method reads from is shown below.

### A textfile of the grid to use.
![textfile grid](https://cloud.githubusercontent.com/assets/24378046/21820674/a3f2aa16-d73e-11e6-84a0-a5aab569004c.png)

### The method fillgrid reads from the textfile above and populates the grid to give you the following image.
![textfilegridgui](https://cloud.githubusercontent.com/assets/24378046/21820678/a64e5c9c-d73e-11e6-843e-fd38b085b501.png)

## Author
Jay Nayak

