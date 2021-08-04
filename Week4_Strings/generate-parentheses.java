class Solution {
    private void validPermutation(String s, int l, int r, int n, List<String> acc) {
        if (l + r == 2 * n) {
            acc.add(s);
            return;
        }

        if (l < n) {
            validPermutation(s + "(", l + 1, r, n, acc);
        }

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