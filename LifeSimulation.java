/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */


public class LifeSimulation {

//     public static void main(String[] args) throws InterruptedException {

//         if (args.length < 2) {
//             System.out.println("Usage: java LifeSimulation <grid size> <num steps>");
//             return;
//         }

//         int gridSize = Integer.parseInt(args[0]);
//         int numSteps = Integer.parseInt(args[1]);

//         Landscape landscape = new Landscape(gridSize, gridSize, 0.3);
//         LandscapeDisplay display = new LandscapeDisplay(landscape, 10);

//         // Visualize initial board
//         display.repaint();
//         Thread.sleep(250);

//         // Simulate numSteps time steps
//         for (int i = 0; i < numSteps; i++) {
//             landscape.advance();
//             display.repaint();
//             Thread.sleep(250);
//         }
//     }
// }

// javac LifeSimulation.java
// java LifeSimulation 20 50

// // Hypothesis: The higher the initial status chance, the higher the number of living cells after a sufficiently long time.

// To test this hypothesis, we can create several landscapes of the same size with different initial status chance values, run each landscape for 1000 rounds, and compare the final number of living cells.

// For example, we can create landscapes with initial status chance values of 0.1, 0.3, 0.5, and 0.7, all with a size of 100x100 cells. We can run each simulation for 1000 rounds and record the final number of living cells for each simulation.

// We can then plot the results and analyze the data to see if there is a correlation between initial status chance and the number of living cells after a sufficient number of rounds.

// We can also perform statistical analysis to determine the significance of our results, such as calculating the mean and standard deviation of the number of living cells for each simulation.

// Overall, our hypothesis suggests that a higher initial status chance will result in a higher number of living cells after a sufficiently long time. The experiments we perform can help us determine if this hypothesis is true or false and provide evidence to support our claim.

//*******Extension1********

public static void main(String[] args) throws InterruptedException {

    // Check if the correct number of command line arguments are provided
    if (args.length < 3) {
        System.out.println("Usage: java LifeSimulation <grid size> <density> <num steps>");
        return;
    }

    // Parse command line arguments
    int gridSize = Integer.parseInt(args[0]);  // size of the grid
    double density = Double.parseDouble(args[1]);  // density of live cells
    int numSteps = Integer.parseInt(args[2]);  // number of simulation steps to perform

    // Create the landscape
    Landscape landscape = new Landscape(gridSize, gridSize, density);
    
    // Create a display window to visualize the landscape
    LandscapeDisplay display = new LandscapeDisplay(landscape, 100);  // 100 ms refresh rate

    // Visualize initial board
    display.repaint();  // redraw the display
    Thread.sleep(250);  // wait for 250 ms before continuing

    // Simulate numSteps time steps
    for (int i = 0; i < numSteps; i++) {
        landscape.advance();  // advance the simulation by one time step
        display.repaint();  // redraw the display
        Thread.sleep(250);  // wait for 250 ms before continuing to the next time step
    }
}
}