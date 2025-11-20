import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.awt.Point;

/**
 * PathFinder class for finding a path between two cells in a maze.
 * You'll find in this class the method to implement.
 */
public class PathFinder {

    /**
     * Finds a path from the start cell to the end cell in the maze.
     * 
     * @param startCell The starting point (row, col) in the maze
     * @param endCell   The destination point (row, col) in the maze
     * @param rows      Number of rows in the maze
     * @param cols      Number of columns in the maze
     * @param walls     2D array where true = wall, false = passage
     * @return A list of Points representing the path from start to end (both inclusive), or an empty list if no path exists
     */
    public static List<Point> findPath(
            Point startCell,
            Point endCell,
            int rows, int cols,
            boolean[][] walls
    ) {

        if (startCell == null || endCell == null) {
            return new ArrayList<>();
        }

        List<Point> path = new ArrayList<>();
        Set<Point> visited = new HashSet<>();

        // Try to find a path using recursive DFS
        if (findPathRecursive(startCell, endCell, rows, cols, walls, visited, path)) {
            return path;
        }

        return new ArrayList<>(); // No path found
    }

    /**
     * Recursively finds a path using depth-first search.
     * This is the method you need to implement.
     * 
     * @param current Current cell position
     * @param end     Destination cell
     * @param rows    Number of rows in the maze
     * @param cols    Number of columns in the maze
     * @param walls   2D array where true = wall, false = passage
     * @param visited Set of already visited cells
     * @param path    Current path being built
     * @return true if a path to the end is found, false otherwise
     */
    private static boolean findPathRecursive(
            Point current,
            Point end,
            int rows, int cols,
            boolean[][] walls,
            Set<Point> visited,
            List<Point> path
    ) {
        path.add(current);
        visited.add(current);
        if (current.equals(end)) {
            return true;
        }

        // Get current coordinates

        int X_coord = current.x;
        int Y_coord = current.y;

        if (canMoveUp(X_coord, Y_coord, walls)){
            Point next = new Point(X_coord -1, Y_coord);
            if (visited.contains(next) != true) {
                if (findPathRecursive(next, end, rows, cols, walls, visited, path)) {
                    return true;
                }
            }
        }
        if (canMoveLeft(X_coord, Y_coord, walls)){
            Point next = new Point(X_coord, Y_coord-1);
            if (visited.contains(next) != true) {
                if (findPathRecursive(next, end, rows, cols, walls, visited, path)) {
                    return true;
                }

            }
        }
        if (canMoveRight(X_coord, Y_coord, cols, walls)){
            Point next = new Point(X_coord, Y_coord + 1);
            if (visited.contains(next) != true) {
                if (findPathRecursive(next, end, rows, cols, walls, visited, path)) {
                    return true;

                }
            }


        }
        if (canMoveDown(X_coord, Y_coord, rows, walls)){
            Point next = new Point(X_coord + 1, Y_coord);
            if (visited.contains(next) != true) {
                if (findPathRecursive(next, end, rows, cols, walls, visited, path)) {
                    return true;
                }

            }

        }
        path.remove(path.size()-1);
        return false;
    }

    /**
     * Check if we can move up from the current cell.
     * 
     * @param row   Current row
     * @param col   Current column
     * @param walls 2D array where true = wall, false = passage
     */
    private static boolean canMoveUp(int row, int col, boolean[][] walls) {
        // Can't move up from the first row
        if (row == 0) {
            return false;
        }
        // Check if the cell above is a passage (not a wall)
        return !walls[row - 1][col];
    }

    /**
     * Check if we can move down from the current cell.
     * 
     * @param row   Current row
     * @param col   Current column
     * @param rows  Total number of rows
     * @param walls 2D array where true = wall, false = passage
     */
    private static boolean canMoveDown(int row, int col, int rows, boolean[][] walls) {
        // Can't move down from the last row
        if (row == rows - 1) {
            return false;
        }
        // Check if the cell below is a passage (not a wall)
        return !walls[row + 1][col];
    }

    /**
     * Check if we can move left from the current cell.
     * 
     * @param row   Current row
     * @param col   Current column
     * @param walls 2D array where true = wall, false = passage
     */
    private static boolean canMoveLeft(int row, int col, boolean[][] walls) {
        // Can't move left from the first column
        if (col == 0) {
            return false;
        }
        // Check if the cell to the left is a passage (not a wall)
        return !walls[row][col - 1];
    }

    /**
     * Check if we can move right from the current cell.
     * 
     * @param row   Current row
     * @param col   Current column
     * @param cols  Total number of columns
     * @param walls 2D array where true = wall, false = passage
     */
    private static boolean canMoveRight(int row, int col, int cols, boolean[][] walls) {
        // Can't move right from the last column
        if (col == cols - 1) {
            return false;
        }
        // Check if the cell to the right is a passage (not a wall)
        return !walls[row][col + 1];
    }
}
