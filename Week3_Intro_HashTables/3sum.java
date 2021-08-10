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
            /* if first index or non-repeating starting number, start 3sum */
            if (i == 0 || nums[i] != nums[i - 1]) {
                threeSumAux(nums, i, out);
            }
        }
        return out;
    }

    public void threeSumAux(int[] nums, int i, List<List<Integer>> out) {
        /* Pointer to lowest number after nums[i] */
        int left = i + 1;
        /* pointer to last index (and hence, largest number) */
        int right = nums.length - 1;
        while (left < right) {
            int target = nums[i] + nums[left] + nums[right];
            if (target == 0) {
                out.add(Arrays.asList(nums[i], nums[left], nums[right]));
                /* prevent repeating triplets */
                left++;
                right--;
                /* prevent repreating triplets by making sure next number is different */
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else if (target > 0) {
                /**
                 * If sum of 3 elements is positive, then sum needs
                 * to decrease. shift right pointer to lower number
                 */
                right--;
            } else {
                /**
                 * If sum of 3 elements is negative, then sum needs
                 * to decrease. shift left pointer to higher number
                 */
                left++;
            }
        }z
    }
}