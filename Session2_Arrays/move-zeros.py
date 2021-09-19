class Solution:
    # Simpler version of sort colors
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # Pointer to store number of non-zeros seen during traversal
        # non zeros used to push zeros to the back
        nonZeroPtr = 0
        for i in range(len(nums)):
            num = nums[i]
            # if number not 0, then perform swapping operation
            if num != 0:
                nums[i], nums[nonZeroPtr] = nums[nonZeroPtr], nums[i]
                # shift non-zeros pointer to the right
                nonZeroPtr += 1