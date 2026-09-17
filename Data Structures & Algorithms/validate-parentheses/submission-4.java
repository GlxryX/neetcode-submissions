class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (c == ')') {
                    if (stack.peek() != '(') return false;
                    else stack.pop();
                }
                if (c == '}') {
                    if (stack.peek() != '{') return false;
                    else stack.pop();
                }
                if (c == ']') {
                    if (stack.peek() != '[') return false;
                    else stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
