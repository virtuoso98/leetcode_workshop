class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        stk = []
        valid = [0 for i in range(len(s))]
        
        for i in range(len(s)):
            if s[i] == "(":
                stk.append(i)
            elif len(stk) != 0:
                pair = stk.pop()
                valid[pair] = 1
                valid[i] = 1
        
        final_max = 0
        curr_max = 0
        for j in valid:
            if j == 1:
                curr_max += 1
            else:
                final_max = max(curr_max, final_max)
                curr_max = 0
        
        return max(final_max, curr_max)