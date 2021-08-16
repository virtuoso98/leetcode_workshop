import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        /* Initialize HashMap */
        Map<Integer, Integer> freq = new HashMap<>();

        /* Majority Threshold defined in the question */
        int majorityThreshold = nums.length / 2;

        for (int i : nums) {
            /* Java's pattern for finding count */
            freq.put(i, freq.getOrDefault(i, 0) + 1);
            /* Check whether majority element */
            if (freq.get(i) > majorityThreshold)
                return i;
        }

        /* Dead line of code since majority element is guaranteed */
        return -1;
    }
}