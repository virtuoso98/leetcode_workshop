class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        nonZeroPtr = 0
        for i in range(len(nums)):
            num = nums[i]
            if num != 0:
                nums[i], nums[nonZeroPtr] = nums[nonZeroPtr], nums[i]
                nonZeroPtr += 1