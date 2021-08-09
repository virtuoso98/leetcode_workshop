import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        /* Sort array in ascending order */
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            /**
             * If lowest element is positive, then
             * sum of triplets must be positive, which != 0
             */
            if (nums[i] > 0) {
                break;
            }
            /* if first inde of non-repeating starting number, start 3sum */
            if (i == 0 || nums[i] != nums[i - 1]) {
                threeSumAux(nums, i, out);
            }
        }
        return out;
    }

    public void threeSumAux(int[] nums, int i, List<List<Integer>> out) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int target = nums[i] + nums[left] + nums[right];
            if (target == 0) {
                out.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else if (target > 0) {
                right--;
            } else {
                left++;
            }
        }
    }
}