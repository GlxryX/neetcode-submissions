class Solution {
    int max;
    public int maxAreaOfIsland(int[][] grid) {
        this.max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int currentIslandArea = dfs(i, j, grid);
                    max = Math.max(max, currentIslandArea);
                }
            }
        }

        return max;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
        
        grid[i][j] = 0;
        int currentArea = 1;
        currentArea += dfs(i - 1, j, grid);
        currentArea += dfs(i + 1, j, grid);
        currentArea += dfs(i, j + 1, grid);
        currentArea += dfs(i, j - 1, grid);

        return currentArea;
    }
}
