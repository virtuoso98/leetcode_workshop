class Solution {
    public void sortColors(int[] nums) {
        int twoPtr = nums.length - 1;
        int zeroPtr = 0;
        int curr = 0;

        while (curr <= twoPtr) {
            int num = nums[curr];
            switch (num) {
                case 0:
                    swap(nums, zeroPtr, curr);
                    curr++;
                    zeroPtr++;
                    break;
                case 2:
                    swap(nums, twoPtr, curr);
                    twoPtr--;
                    break;
                default:
                    curr++;
                    break;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}