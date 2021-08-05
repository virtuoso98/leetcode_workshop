class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        def validPermutation(acc = "", l = 0, r = 0):
            if l + r == 2 * n:
                ans.append(acc)
                return
            if l < n:
                validPermutation(acc + "(", l + 1, r)
            if r < l:
                validPermutation(acc + ")", l, r + 1)
        validPermutation()
        return ans