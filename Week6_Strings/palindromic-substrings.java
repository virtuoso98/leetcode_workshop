class Solution {
    public int expandFromCtr(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                count++; l--; r++;
            }
            else break;
        }   
        return count;
    }
    
    public int countSubstrings(String s) {
        int totalCount = 0;
        for (int i = 0; i < s.length(); i++) {
            totalCount += expandFromCtr(s, i, i);
            totalCount += expandFromCtr(s, i, i + 1);
        }
        return totalCount;
    }
}