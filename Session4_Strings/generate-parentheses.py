class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        # n can be used by validPermutation since it is 
        # in scope of generateParentheses.
        def validPermutation(acc = "", l = 0, r = 0):
            """
            acc - accumulator
            l - Number of '(' instances
            r - Number of ')' instances
            """
            # number of brackets = pairs of brackets * 2
            if l + r == 2 * n:
                ans.append(acc)
                return
            # If number of left parentheses lesser than max number of pairs
            if l < n:
                validPermutation(acc + "(", l + 1, r)
            # If number of right parentheses lesser than left,
            # Then we can form a pair. Append ")" to the right of string
            if r < l:
                validPermutation(acc + ")", l, r + 1)
        validPermutation()
        return ans