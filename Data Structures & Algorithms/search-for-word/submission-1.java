class Solution {
    char[][] board;
    String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean backtrack(int i, int j, int index) {
        if (board[i][j] != word.charAt(index)) return false;
        if (index == word.length() - 1) {
            return true;
        }
        
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = false;
        if (i != board.length - 1){
            found |= backtrack(i + 1, j, index + 1);
        }
        if (i != 0){
            found |= backtrack(i - 1, j, index + 1);
        }
        if (j != board[0].length - 1){
            found |= backtrack(i, j + 1, index + 1);
        }
        if (j != 0){
            found |= backtrack(i, j - 1, index + 1);
        }
        
        board[i][j] = temp;
        return found;
    }
}
