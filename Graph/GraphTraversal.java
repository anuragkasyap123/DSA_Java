package Graph;

public class GraphTraversal {
    public static void traverse(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return;
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

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < columns; column++) {
             System.out.print(grid[row][column] + " ");
            }

            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        traverse(grid);
    }
}
