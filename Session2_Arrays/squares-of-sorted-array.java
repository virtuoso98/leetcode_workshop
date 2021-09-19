class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            /* Square each number in the Array */
            nums[i] = nums[i] * nums[i];
        }
        
        /* Run in-house sorting method */
        Arrays.sort(nums);
        return nums;
    }
}