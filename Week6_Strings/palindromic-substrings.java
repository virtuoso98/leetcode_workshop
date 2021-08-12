class Solution {
    public int expandFromCtr(String s, int l, int r) {
        int count = 0;
        /* Ensure no out of bounds condition */
        while (l >= 0 && r < s.length()) {
            /* If the l and r pointer have same character */
            if (s.charAt(l) == s.charAt(r)) {
                /**
                 * Increase count due to presence of palindrome
                 * Move left pointer outward (to the left)
                 * Move right pointer outward (to the right)
                 */
                count++; l--; r++;
            }
            /* No more possible palindromes since char mismatch */
            else break;
        }   
        return count;
    }
    
    public int countSubstrings(String s) {
        int totalCount = 0;
        for (int i = 0; i < s.length(); i++) {
            /* Odd length palindrome case */
            totalCount += expandFromCtr(s, i, i);
            /* Even length palindrome case  */
            totalCount += expandFromCtr(s, i, i + 1);
        }
        return totalCount;
    }
}