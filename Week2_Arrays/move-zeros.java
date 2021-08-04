class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroPtr = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                int temp = nums[i];
                nums[i] = nums[nonZeroPtr];
                nums[nonZeroPtr] = temp;
                nonZeroPtr++;
            }
        }
    }
}