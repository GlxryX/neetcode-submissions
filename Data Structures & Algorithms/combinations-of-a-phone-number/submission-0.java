class Solution {
    List<String> list = new ArrayList<>();
    String digits;
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return list;
        this.digits = digits;
        backtrack(0, "");
        return list;
    }

    private void backtrack(int index, String curr) {
        if (curr.length() == digits.length()) {
            list.add(curr);
            return;
        }

        String chars = digitToChar[digits.charAt(index) - '0'];

        for (char c : chars.toCharArray()) {
            backtrack(index + 1, curr + c);
        }
    }
}
