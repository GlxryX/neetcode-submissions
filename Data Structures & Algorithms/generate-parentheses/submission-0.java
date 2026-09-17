class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(new String(""), n, n);

        return list;
    }

    private void backtrack(String curr, int open, int close) {
        if (open == 0 && close == 1) {
            list.add(curr + ")");
            return;
        }

        if (open > 0) {
            backtrack(curr + "(", open - 1, close); 
        }
        if (close > open) {
            backtrack(curr + ")", open, close -1);
        }
    }
}
