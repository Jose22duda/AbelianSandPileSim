// A class for implemetation of the parallel version for the serial version of Sandpile
// JOSEPH VUSUMZI DUDAs
package parallelAbelianSandpile;

import java.util.concurrent.RecursiveAction;

public class ParallelGrid extends RecursiveAction {
    private final Grid grid;
    private final int startRow, endRow;
// constructor that takes in arguments
    public ParallelGrid(Grid newgrid, int startRow, int endRow) {
        this.grid = newgrid;
        this.startRow = startRow;
        this.endRow = endRow;

    }
// compute method
    @Override
    protected void compute() {
        if ((endRow - startRow) <= 1000 ) {
            grid.update();
        } else {
            // Split the task into two halves
            int midRow = (startRow + endRow) / 2;
            
            // create two new objects of Parallel Grid
            ParallelGrid topHalf = new ParallelGrid(grid, startRow, midRow);
            ParallelGrid bottomHalf = new ParallelGrid(grid, midRow, endRow);

            // Fork the top half task and compute the bottom half
            topHalf.fork();
            bottomHalf.compute();
            topHalf.join();  // Ensure the top half task completes before continuing
        }
    }
}
