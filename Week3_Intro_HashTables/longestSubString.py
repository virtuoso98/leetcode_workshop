class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        charLatestIdx = {}
        leftPtr = 0
        maxLength = 0
        for i in range(len(s)):
            if (s[i] in charLatestIdx):
                leftPtr = max(charLatestIdx[s[i]], leftPtr) 
            maxLength = max(maxLength, i - leftPtr + 1)
            charLatestIdx[s[i]] = i + 1
        return maxLength