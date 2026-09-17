class Solution {
    public static boolean isValid(String s) {
        if (s.length() == 0 || s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                char top = stack.peek();
                if (c == ')' && top == '(' ||
                        c == '}' && top == '{' ||
                        c == ']' && top == '[')
                    stack.pop();
                else
                    return false;
            }
        }
        return (stack.isEmpty());
    }
}