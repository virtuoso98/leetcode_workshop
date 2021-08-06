class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<Integer>();
        int[] valid = new int[s.length()];
        Arrays.fill(valid, 0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else if (!(stk.isEmpty())) {
                int comp = stk.pop();
                valid[comp] = 1;
                valid[i] = 1;
            }
        }

        int finalMax = 0;
        int currMax = 0;
        for (int j : valid) {
            if (j == 1) {
                currMax++;
            } else {
                finalMax = Math.max(finalMax, currMax);
                currMax = 0;
            }
        }
        return Math.max(finalMax, currMax);
    }
}