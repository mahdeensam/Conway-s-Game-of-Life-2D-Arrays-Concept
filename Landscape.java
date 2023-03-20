/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */


import java.awt.*;
import java.util.ArrayList;

// Declare a class named "Landscape"
public class Landscape {

    private Cell[][] landscape;  // 2D array to store the cells
    private int rows;  // number of rows in the landscape
    private int cols;  // number of columns in the landscape
    private double initialChance; // initial chance that a cell is alive

    // Constructor that creates a landscape with the given number of rows and columns
    public Landscape(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        landscape = new Cell[rows][cols];
        reset(); // Initialize the landscape with random cell states
    }

    // Constructor that creates a landscape with the given number of rows, columns, and initial chance of a cell being alive
    public Landscape(int rows, int cols, double chance) {
        this.rows = rows;
        this.cols = cols;
        this.initialChance = chance;
        landscape = new Cell[rows][cols];
        reset(); // Initialize the landscape with random cell states
    }

    // Initializes the landscape with random cell states based on the initial chance
    public void reset() {
        for (int i = 0; i < rows; i++) { // Iterate over each row
            for (int j = 0; j < cols; j++) { // Iterate over each column in the current row
                if (Math.random() < initialChance) {  // If the random number is less than the initial chance
                    landscape[i][j] = new Cell(true); // The cell is alive
                } else {
                    landscape[i][j] = new Cell(false); // Otherwise, the cell is dead
                }
            }
        }
    }


    public int getRows() {
        return rows; // Return the number of rows in the landscape
    }
    
    public int getCols() {
        return cols; // Return the number of columns in the landscape
    }
    
    public Cell getCell(int row, int col) {
        return landscape[row][col]; // Return the cell at the specified row and column
    }
    
    // Returns a string representation of the landscape, with each row separated by a newline character
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) { // Iterate over each row
            for (int j = 0; j < cols; j++) { // Iterate over each column in the current row
                sb.append(landscape[i][j].toString()); // Append the string representation of the cell to the StringBuilder
            }
            sb.append("\n"); // Add a newline character to the StringBuilder after each row
        }
        return sb.toString(); // Convert the StringBuilder to a string and return it
    }
    
    // Returns an ArrayList containing the neighbors of the cell at the specified row and column
    public ArrayList<Cell> getNeighbors(int row, int col) {
        ArrayList<Cell> neighbors = new ArrayList<Cell>(); // Create a new ArrayList to hold the neighbors
        for (int i = row - 1; i <= row + 1; i++) { // Iterate over each row surrounding the current cell
            for (int j = col - 1; j <= col + 1; j++) { // Iterate over each column surrounding the current cell
                if (i >= 0 && i < rows && j >= 0 && j < cols && !(i == row && j == col)) { // Check that the row and column are within bounds and not the current cell
                    neighbors.add(landscape[i][j]); // Add the neighbor to the ArrayList
                }
            }
        }
        return neighbors; // Return the ArrayList of neighbors
    }
    

    // Advances the simulation to the next generation of cells
public void advance() {
    // Create a temporary grid to hold the new generation of cells
    Cell[][] tempGrid = new Cell[rows][cols];

    // Loop through the current grid and update the temporary grid
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            Cell currentCell = landscape[i][j]; // Get the current cell
            ArrayList<Cell> neighbors = getNeighbors(i, j); // Get the neighbors of the current cell
            Cell newCell = new Cell(currentCell.getAlive()); // Create a new cell with the same state as the current cell
            newCell.updateState(neighbors); // Update the state of the new cell based on the neighbors
            tempGrid[i][j] = newCell; // Add the new cell to the temporary grid
        }
    }

    // Update the original grid with the new generation of cells
    landscape = tempGrid;
}

// Draws the current state of the simulation using the given graphics object and scale
public void draw(Graphics g, int scale) {
    for (int x = 0; x < getRows(); x++) { // Iterate over each row
        for (int y = 0; y < getCols(); y++) { // Iterate over each column in the current row
            g.setColor(getCell(x, y).getAlive() ? Color.BLACK : Color.gray); // Set the color of the graphics object based on the state of the cell
            g.fillOval(x * scale, y * scale, scale, scale); // Draw an oval representing the cell
        }
    }
}

// Main method for testing the Landscape class
public static void main(String[] args) {
    Landscape landscape = new Landscape(10, 10, 0.5); // Create a new Landscape object with 10 rows, 10 columns, and a 50% chance of a cell being alive
    System.out.println(landscape.toString()); // Print the initial state of the Landscape
    landscape.advance(); // Advance the simulation to the next generation
    System.out.println(landscape.toString()); // Print the state of the Landscape after advancing
}
}