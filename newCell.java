/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

import java.util.ArrayList;

// Define the base class for a cell
class newCell {
    // Each cell has a boolean value to store whether it is alive or not
    private boolean alive;

    // Default constructor creates a dead cell
    public newCell() {
        this.alive = false;
    }

    // Constructor that allows setting the initial state of the cell
    public newCell(boolean status) {
        this.alive = status;
    }

    // Returns the current state of the cell
    public boolean getAlive() {
        return this.alive;
    }

    // Sets the current state of the cell
    public void setAlive(boolean status) {
        this.alive = status;
    }

    // Update the state of the cell based on the state of its neighbors
    public void updateState(ArrayList<Cell> neighbors) {
        int aliveNeighbors = 0;

        // Count the number of alive neighbors
        for (Cell neighbor : neighbors) {
            if (neighbor.getAlive()) {
                aliveNeighbors++;
            }
        }

        // Update the state of the cell based on the number of alive neighbors
        if (this.alive) {
            if (aliveNeighbors != 2 && aliveNeighbors != 3) {
                this.alive = false;
            }
        } else {
            if (aliveNeighbors == 3) {
                this.alive = true;
            }
        }
    }

    // Returns a string representation of the cell, with "1" representing alive and "0" representing dead
    public String toString() {
        return this.alive ? "1" : "0";
    }
}

// Define a subclass of cell that is always alive
class ImmortalCell extends Cell {
    public ImmortalCell() {
        // Call the constructor of the base class to set the initial state to alive
        super(true);
    }

    // Override the updateState() method so that the cell will always remain alive
    @Override
    public void updateState(ArrayList<Cell> neighbors) {
        // Do nothing, the cell will always remain alive
    }
}

// Define a subclass of cell that can be either alive or dead
class NormalCell extends Cell {
    public NormalCell() {
        // Call the constructor of the base class to set the initial state to dead
        super(false);
    } 
}

// Define the main class that runs the game
class GameOfLife {
    public static void main(String[] args) {
        // Create a 10x10 grid of cells
        Cell[][] grid = new Cell[10][10];

        // Fill the grid with a mix of normal and immortal cells
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Math.random() < 0.5) {
                    grid[i][j] = new NormalCell();
                } else {
                    grid[i][j] = new ImmortalCell();
                }
            }
        }

        // Update the state of each cell based on the state of its neighbors
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ArrayList<Cell> neighbors = new ArrayList<Cell>();

                // Add the neighboring cells to the ArrayList
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        if (i + di >= 0 && i + di < 10 && j + dj >= 0 && j + dj < 10) {
                            if (!(di == 0 && dj == 0)) {
                                neighbors.add(grid[i + di][j + dj]);
                            }
                        }
                    }
                }

                // Call the updateState() method on the current cell, passing in its neighbors
                grid[i][j].updateState(neighbors);
            }
        }

        // Print the updated grid
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // If the current cell is an instance of ImmortalCell, print "I" instead of its state
                if (grid[i][j] instanceof ImmortalCell) {
                    System.out.print("I");
                } else {
                    System.out.print(grid[i][j].toString());
                }
            }
            System.out.println();
        }
    }
}



/*
This output represents a 10x10 grid of cells where 0 represents a NormalCell and I represents an ImmortalCell. The grid is printed after updating the state of each cell according to the rules of Conway's Game of Life, with each cell's state depending on the states of its neighbors.

The grid was initially filled with a mix of normal and immortal cells, with the proportion of each type determined by a random number generator. The updateState() method was then called for each cell to update its state, with the neighboring cells passed as an ArrayList. The new state of each cell was then printed to the console.

Note that the behavior of the ImmortalCell class is different from that of the NormalCell class, as an ImmortalCell will never die regardless of the state of its neighbors. */