import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i == 0 || nums[i] != nums[i - 1]) {
                threeSumAux(nums, i, out);
            }
        }
        return out;
    }

    public void threeSumAux(int[] nums, int i, List<List<Integer>> out) {
        int j = i + 1;
        var seen = new HashSet<Integer>();
        while (j < nums.length) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                out.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            seen.add(nums[j]);
            j++;
        }
    }
}