class Solution {
    private void validPermutation(String s, int l, int r, int n, List<String> acc) {
        /* number of brackets = pairs of brackets * 2 */
        if (l + r == 2 * n) {
            acc.add(s);
            return;
        }

        /* If number of left parentheses lesser than max allowed number of pairs */
        if (l < n) {
            validPermutation(s + "(", l + 1, r, n, acc);
        }

        /**
         * If number of right parentheses lesser than left
         * then we can form a pair. Apeend ")" to right of string.
         */
        if (r < l) {
            validPermutation(s + ")", l, r + 1, n, acc);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> acc = new ArrayList<>();
        validPermutation("", 0, 0, n, acc);
        return acc;
    }
}