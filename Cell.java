/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

import java.util.ArrayList;

public class Cell {

    /**
     * The status of the Cell.
     */
    private boolean alive;

    /**
     * Constructs a dead cell.
     */
    public Cell() {
        this.alive = false;
    }

    /**
     * Constructs a cell with the specified status.
     *
     * @param status a boolean to specify if the Cell is initially alive
     */
    public Cell(boolean status) {
        this.alive = status;
    }

    /**
     * Returns whether the cell is currently alive.
     *
     * @return whether the cell is currently alive
     */
    public boolean getAlive() {
        return this.alive;
    }

    /**
     * Sets the current status of the cell to the specified status.
     *
     * @param status a boolean to specify if the Cell is alive or dead
     */
    public void setAlive(boolean status) {
        this.alive = status;
    }

    /**
     * Returns a String representation of this Cell.
     *
     * @return 1 if this Cell is alive, otherwise 0.
     */
    public String toString() {
        if (this.alive) {
            return "1";
        } else {
            return "0";
        }
    }

        /******EXTENSION 1*******\
     * Updates the state of the Cell.
     *
     * If this Cell is alive and if there are 2 or 3 alive neighbors,
     * this Cell stays alive. Otherwise, it dies.
     *
     * If this Cell is dead and there are 3 alive neighbors,
     * this Cell comes back to life. Otherwise, it stays dead.
     *
     * @param neighbors An ArrayList of Cells
     */
    // public void updateState(ArrayList<Cell> neighbors) {
    //     // Count the number of alive neighbors
    //     int aliveNeighbors = 0;
      
    //     // Update the state of the Cell based on the number of alive neighbors
    //     if (this.alive) { // If the Cell is currently alive
    //       if (aliveNeighbors != 2 && aliveNeighbors != 3) { // If it has too few or too many alive neighbors
    //         this.alive = false; // The Cell dies
    //       }
    //     } else { // If the Cell is currently dead
    //       if (aliveNeighbors == 3) { // If it has exactly three alive neighbors
    //         this.alive = true; // The Cell comes back to life
    //       }
    //     }
    //     for (Cell neighbor : neighbors) {
    //         if (neighbor.getAlive()) {
    //           aliveNeighbors++;
    //         }
    //   }
    // }

    public void updateState(ArrayList<Cell> neighbors) {
        // Count the number of alive neighbors
        int aliveNeighbors = 0;
        for (Cell neighbor : neighbors) {
            if (neighbor.getAlive()) {
                aliveNeighbors++;
            }
        }
    
        // Update the state of the cell based on the number of alive neighbors
        if (this.alive) { // If the cell is currently alive
            if (aliveNeighbors == 1 || aliveNeighbors == 2 || aliveNeighbors == 4) {
                this.alive = true; // The cell remains alive if it has 1, 2, or 4 alive neighbors
            } else {
                this.alive = false; // Otherwise, the cell dies
            }
        } else { // If the cell is currently dead
            if (aliveNeighbors == 2 || aliveNeighbors == 5) {
                this.alive = true; // The cell becomes alive if it has 2 or 5 alive neighbors
            } else {
                this.alive = false; // Otherwise, the cell remains dead
            }
        }
    }
    
  

    
    public static void main(String[] args) {
        Cell c1 = new Cell();
        System.out.println(c1.getAlive()); // Output: false
        System.out.println(c1); // Output: 0
    
        Cell c2 = new Cell(true);
        System.out.println(c2.getAlive()); // Output: true
        System.out.println(c2); // Output: 1
    
        c1.setAlive(true);
        System.out.println(c1.getAlive()); // Output: true
        System.out.println(c1); // Output: 1
    }
}    


//     public static void main(String[] args) {
//         // Create a 3x3 grid of cells
//         Cell[][] grid = new Cell[3][3];
//         for (int i = 0; i < 3; i++) {
//             for (int j = 0; j < 3; j++) {
//                 grid[i][j] = new Cell();
//             }
//         }

//         // Set some cells as alive
//         grid[0][1].setAlive(false);
//         grid[1][1].setAlive(false);
//         grid[2][1].setAlive(false);

//         // Update the state of each cell
//         for (int i = 0; i < 3; i++) {
//             for (int j = 0; j < 3; j++) {
//                 ArrayList<Cell> neighbors = new ArrayList<Cell>();

//                 // Add the neighboring cells to the ArrayList
//                 for (int di = -1; di <= 1; di++) {
//                     for (int dj = -1; dj <= 1; dj++) {
//                         if (i + di >= 0 && i + di < 3 && j + dj >= 0 && j + dj < 3) {
//                             if (!(di == 0 && dj == 0)) {
//                                 neighbors.add(grid[i + di][j + dj]);
//                             }
//                         }
//                     }
//                 }

//                 grid[i][j].updateState(neighbors);
//             }
//         }

//         // Print the updated grid
//         for (int i = 0; i < 3; i++) {
//             for (int j = 0; j < 3; j++) {
//                 System.out.print(grid[i][j].toString());
//             }
//             System.out.println();
//         }
//     }
// }