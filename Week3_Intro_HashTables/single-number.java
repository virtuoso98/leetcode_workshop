import java.util.HashMap;

class Solution {
    public int singleNumber(int[] nums) {
        /* Create Frequency Table */
        HashMap<Integer, Integer> freq_table = new HashMap<>();

        /*
         * Loop through Array. If value does not exist in HashMap, 
         * then set default to 1. If not, add 1 to existing value
         */
        for (int i : nums) {
            freq_table.put(i, freq_table.getOrDefault(i, 0) + 1);
        }

        /* Find the number that only occurs once in Frequency table */
        for (int j : nums) {
            if (freq_table.get(j) == 1) {
                return j;
            }
        }
        return 0;
    }
}