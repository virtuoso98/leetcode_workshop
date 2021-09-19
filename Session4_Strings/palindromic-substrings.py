class Solution:
    def expandFromCtr(self, s, l, r):
        count = 0
        # Ensure no out of bounds condition
        while l >= 0 and r < len(s):
            # If the l and r pointer have same character
            if s[l] == s[r]:
                # Increase count due to presence of palindrome
                count += 1
                # Move left pointer outward (to the left)
                l -= 1
                # Move right pointer outward (to the right)
                r += 1
            # No more possible palindromes since char mismatch
            else:
                break
        return count
                
    
    def countSubstrings(self, s: str) -> int:
        totalCount = 0
        for i in range(len(s)):
            # Odd length palindrome case
            totalCount += self.expandFromCtr(s, i, i)
            # Even Length Palindrome case
            totalCount += self.expandFromCtr(s, i, i + 1)
        return totalCount