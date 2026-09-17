class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) q.add(new int[]{r, c, 0});
            }
        }

        int[][] directions = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while(!q.isEmpty()) {
            int[] curr = q.remove();

            for (int[] dir : directions) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];
                int dist = curr[2] + 1;
                if (
                    row < grid.length &&
                    row >= 0 &&
                    col < grid[0].length &&
                    col >= 0 &&
                    grid[row][col] != -1 &&
                    grid[row][col] == Integer.MAX_VALUE
                ) {
                    grid[row][col] = dist;
                    q.add(new int[]{row, col, dist});
                }
            }
        }
    }
}
