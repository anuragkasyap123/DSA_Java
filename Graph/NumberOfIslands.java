package Graph;
import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    public static int countIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        if (grid[0] == null) {
            throw new IllegalArgumentException("Grid rows must not be null");
        }

        int columns = grid[0].length;
        for (char[] row : grid) {
            if (row == null || row.length != columns) {
                throw new IllegalArgumentException("Grid must be rectangular");
            }
            for (char cell : row) {
                if (cell != '0' && cell != '1') {
                    throw new IllegalArgumentException("Grid cells must be '0' or '1'");
                }
            }
        }

        boolean[][] visited = new boolean[grid.length][columns];
        int islandCount = 0;
        int[] rowOffsets = {-1, 1, 0, 0};
        int[] columnOffsets = {0, 0, -1, 1};

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == '1' && !visited[row][column]) {
                    islandCount++;
                    Queue<int[]> cells = new ArrayDeque<>();
                    cells.add(new int[] {row, column});
                    visited[row][column] = true;

                    while (!cells.isEmpty()) {
                        int[] cell = cells.remove();
                        for (int direction = 0; direction < rowOffsets.length; direction++) {
                            int nextRow = cell[0] + rowOffsets[direction];
                            int nextColumn = cell[1] + columnOffsets[direction];

                            if (nextRow >= 0 && nextRow < grid.length
                                    && nextColumn >= 0 && nextColumn < columns
                                    && grid[nextRow][nextColumn] == '1'
                                    && !visited[nextRow][nextColumn]) {
                                visited[nextRow][nextColumn] = true;
                                cells.add(new int[] {nextRow, nextColumn});
                            }
                        }
                    }
                }
            }
        }

        return islandCount;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of islands: " + countIslands(grid));
    }
}
