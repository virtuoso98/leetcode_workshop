import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        // Sort numbers in ascending order 
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // if lowest number is positive, then sum must be positive
            // which is more than 0, so we know there are no more triplets
            if (nums[i] > 0) {
                break;
            }
            // start 3sum upon non-repeating starting number or starting index
            if (i == 0 || nums[i] != nums[i - 1]) {
                threeSumAux(nums, i, out);
            }
        }
        return out;
    }

    public void threeSumAux(int[] nums, int i, List<List<Integer>> out) {
        int j = i + 1;
        // initialize sets that have extremely fast lookup time
        var seen = new HashSet<Integer>();
        while (j < nums.length) {
            // required complement such that sum of 3 numbers is 0
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                // prevent repetition of triplet by shifting j
                // pointer to a different integer
                out.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            // add number to seen set
            seen.add(nums[j]);
            j++;
        }
    }
}