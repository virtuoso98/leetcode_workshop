class Solution {
    /* REMEMBER: QN ASKING FOR N(UNIQUE) Numbers */
    public int removeDuplicates(int[] nums) {
        /* Edge case where array is empty */
        if (nums.length == 0) {
            return 0;
        }

        /* Pointer to show number of unique elements */
        int uniquePtr = 0;
        for (int i = 1; i < nums.length; i++) {
            /* Array is sorted, means nums[i] guaranteed unseen previously*/
            if (nums[i] != nums[i - 1]) {
                /* Add 1 to number of unique elements */
                uniquePtr++;
                nums[uniquePtr] = nums[i];
            }
        }

        /* Since uniquePtr is zero-indexed, increase total by 1 */
        return uniquePtr + 1;
    }
}