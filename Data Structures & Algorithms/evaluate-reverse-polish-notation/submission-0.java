class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                int sum = 0;
                sum += stack.pop();
                sum += stack.pop();
                stack.push(sum);
            }
            else if (s.equals("-")) {
                int val1 = stack.pop();
                stack.push(stack.pop() - val1);
            }
            else if (s.equals("*")) {
                int prod = 1;
                prod *= stack.pop();
                prod *= stack.pop();
                stack.push(prod);
            }
            else if (s.equals("/")) {
                int val1 = stack.pop();
                stack.push(stack.pop() / val1);
            }
            else stack.push(Integer.parseInt(s));
        }

        return stack.pop();
    }
}
