class Solution {
    // simpler version of sort colors
    public void moveZeroes(int[] nums) {
        /* Pointer to store number of non-zeros seen during traversal */
        int nonZeroPtr = 0;
        /* For-loop to push zeros to the rear of array */
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            /* If number not 0, perform swapping */
            if (num != 0) {
                int temp = nums[i];
                nums[i] = nums[nonZeroPtr];
                nums[nonZeroPtr] = temp;
                /* shift non-zero pointer to the right */
                nonZeroPtr++;
            }
        }
    }
}