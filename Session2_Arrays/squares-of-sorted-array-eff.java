class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];   
        /* Assign Pointers to add new value to array */
        int ptr = nums.length - 1;
        /* Pointer for most negative and positive value*/
        int l = 0;
        int r = nums.length - 1;
        
        /* While new Array not completely populated */
        while (ptr >= 0) {
            /* Compare Absolute value */
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                ans[ptr] = nums[l] * nums[l];
                l++;
            } else {
                ans[ptr] = nums[r] * nums[r];
                r--;
            }
            /* Move ptr to left to assign new value */
            ptr--;
        }
        return ans;
    }
}