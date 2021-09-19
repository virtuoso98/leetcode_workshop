class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        # Hashmap that maps seen character to LAST SEEN INDEX
        charLatestIdx = {}
        # Pointer that indicates start of non-repeating substring
        leftPtr = 0
        maxLength = 0
        for i in range(len(s)):
            # Presence of seen character in hashmap
            if (s[i] in charLatestIdx):
                # See if left ptr must shift to ensure non-repeating substring
                leftPtr = max(charLatestIdx[s[i]], leftPtr) 
            # compute maximum length
            maxLength = max(maxLength, i - leftPtr + 1)
            # Record seen character at corresponding index + 1
            charLatestIdx[s[i]] = i + 1
        return maxLength