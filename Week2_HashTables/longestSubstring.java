import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int leftPtr = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            if (map.containsKey(s.charAt(idx))) {
                leftPtr = Math.max(map.get(s.charAt(idx)), leftPtr);
            }
            ans = Math.max(ans, idx - leftPtr + 1);
            map.put(s.charAt(idx), idx + 1);
        }
        return ans;
    }
}