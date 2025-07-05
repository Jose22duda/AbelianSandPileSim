# Parallel Abelian Sandpile Simulation

A Java implementation of the Abelian Sandpile model using parallel processing with Fork/Join framework.

## Project Description
This project implements the Abelian Sandpile cellular automaton model:
- Models sand grains accumulating on a grid
- When a cell reaches 4 grains, it topples and distributes grains to neighbors
- Implements both serial and parallel versions
- Visualizes the sandpile evolution as images

## Features
- **Parallel computation** using Fork/Join framework
- **Efficient grid handling** with border sink cells
- **Multiple visualization options**:
  - Console text output
  - PNG image generation
- **Flexible initialization**:
  - Empty grid
  - Predefined grid
  - Grid copy

## Classes

### Grid.java
- Core grid implementation
- Handles sandpile rules and toppling logic
- Methods:
  - `update()` - Calculates next time step
  - `gridToImage()` - Exports grid as PNG
  - `printGrid()` - Console visualization

### ParallelGrid.java
- Parallel implementation using `RecursiveAction`
- Divides grid into sub-tasks recursively
- Threshold of 1000 rows for sequential cutoff

## How to Run
1. Compile the project:
```bash
javac parallelAbelianSandpile/*.java
