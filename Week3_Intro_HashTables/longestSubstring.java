import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        /* Hashmap that maps seen character to LAST SEEN INDEX */
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        /* Pointer that indicates start of non-repeating substring */
        int leftPtr = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            /* Presence of seen character in hashmap */
            if (map.containsKey(s.charAt(idx))) {
                /* See if left ptr must shift to ensure non-repeating substring */
                leftPtr = Math.max(map.get(s.charAt(idx)), leftPtr);
            }
            /* Compute maximum length */
            ans = Math.max(ans, idx - leftPtr + 1);
            /* Record seen character at corresponding index + 1 */
            map.put(s.charAt(idx), idx + 1);
        }
        return ans;
    }
}