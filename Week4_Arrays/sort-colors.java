class Solution {
    public void sortColors(int[] nums) {
        /* ointer to count number of 2s discovered (placed at back) */
        int twoPtr = nums.length - 1;
        /* Pointer to count number of 0s discovered (placed in front) */
        int zeroPtr = 0;
        /* Index that loops until it encounters border between 1 and 2 */
        int curr = 0;

        /* this while loop works even for cases where arr is already sorted */
        while (curr <= twoPtr) {
            int num = nums[curr];
            switch (num) {
                case 0:
                    /* swap zeroPtr to occupy slot */
                    swap(nums, zeroPtr, curr);
                    /**
                     * Increase currentPtr since swapped element must be 1
                     * or 2 unless it's continuous 0s, which doesn't really matter
                     */
                    curr++;
                    /* Since one '0' is seen, move ptr 1 unit to right */
                    zeroPtr++;
                    break;
                case 2:
                    swap(nums, twoPtr, curr);
                    /**
                     * Do not increase curr ptr since swapped element could be a 0
                     * Since one '2' seen, move pointer 1 unit to left
                     */
                    twoPtr--;
                    break;
                default:
                    /* Element encountered is a 1, nothing else needs to be done */
                    curr++;
                    break;
            }
        }
    }

    /**
     * Auxillary swapping function for arrays
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}