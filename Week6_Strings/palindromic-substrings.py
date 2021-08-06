class Solution:
    def expandFromCtr(self, s, l, r):
        count = 0
        while l >= 0 and r < len(s):
            if s[l] == s[r]:
                count += 1
                l -= 1
                r += 1
            else:
                break
        return count
                
    
    def countSubstrings(self, s: str) -> int:
        totalCount = 0
        for i in range(len(s)):
            totalCount += self.expandFromCtr(s, i, i)
            totalCount += self.expandFromCtr(s, i, i + 1)
        return totalCount