class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        stk = []
        valid = [0 for i in range(len(s))]
        
        """
        The first pass marks 1 in the index of an auxillary
        array if it contains a valid parentheses.
        """
        for i in range(len(s)):
            if s[i] == "(":
                stk.append(i)
            elif len(stk) != 0:
                pair = stk.pop()
                # Mark the respective indexes as valid
                valid[pair] = 1
                valid[i] = 1
        

        """
        Second pass then tries to find the section of the
        auxillary array with the longest continuous "1"s.
        """
        final_max = 0
        curr_max = 0
        for j in valid:
            if j == 1:
                curr_max += 1
            else:
                # if 0 encounted, reset curr_max since 1s
                # are no longer continuous
                final_max = max(curr_max, final_max)
                curr_max = 0
        
        # Exceptional case where even the last index
        # is part of the longest valid substring
        return max(final_max, curr_max)