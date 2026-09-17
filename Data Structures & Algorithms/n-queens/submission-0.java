class Solution {
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    List<List<String>> list = new ArrayList<>();
    char[][] board;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(0);

        return list;
    }

    private void backtrack(int row) {
        if (row == n) {
            List<String> copy = new ArrayList<>();
            for (char[] r : board) {
                copy.add(new String(r));
            }
            list.add(copy);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (
                col.contains(c) ||
                posDiag.contains(row + c) ||
                negDiag.contains(row - c)
            ) continue;
            
            col.add(c);
            posDiag.add(row + c);
            negDiag.add(row - c);
            board[row][c] = 'Q';
            backtrack(row + 1);

            // undo
            col.remove(c);
            posDiag.remove(row + c);
            negDiag.remove(row - c);
            board[row][c] = '.';
        }
    }
}
