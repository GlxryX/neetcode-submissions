class Solution {
    public int orangesRotting(int[][] grid) {
        int goal = 0;
        Queue<int[]> q = new LinkedList<>();
        int timer = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) continue;
                if (grid[r][c] == 1) ++goal;
                if (grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            boolean rotted = false;
            int count = q.size();

            for (int i = 0; i < count; i++) {
                int[] coords = q.poll();
                int row = coords[0];
                int col = coords[1];
                for (int[] dir : directions) {
                    if (
                        row + dir[0] < grid.length &&
                        row + dir[0] >= 0 &&
                        col + dir[1] < grid[0].length &&
                        col + dir[1] >= 0
                    ) {
                        int shiftedR = row + dir[0];
                        int shiftedC = col + dir[1];

                        if (grid[shiftedR][shiftedC] == 1) {
                            grid[shiftedR][shiftedC] = 2;
                            --goal;
                            rotted = true;
                            q.add(new int[]{shiftedR, shiftedC});
                        }
                    }
                }
            }

            if (rotted) ++timer;
        }

        return goal == 0 ? timer : -1;
    }
}
