class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<Integer>();
        int[] valid = new int[s.length()];
        Arrays.fill(valid, 0);


        /**
         * The first pass marks 1 in the index of an auxillary 
         * array if it contains a valid parentheses.
         */
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else if (!(stk.isEmpty())) {
                int comp = stk.pop();
                valid[comp] = 1;
                valid[i] = 1;
            }
        }

        /**
         * Second pass then tries to find the section of the
         * auxillary array with the longest continuous "1"s.
         */
        int finalMax = 0;
        int currMax = 0;
        for (int j : valid) {
            if (j == 1) {
                currMax++;
            } else {
                /**
                 * if 0 encounted, reset curr_max since 1s
                 * are no longer continuous
                 */
                finalMax = Math.max(finalMax, currMax);
                currMax = 0;
            }
        }
        /**
         * Exceptional case where even the last index
         * is part of the longest valid substring
         */
        return Math.max(finalMax, currMax);
    }
}