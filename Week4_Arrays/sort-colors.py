class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        twoPtr = len(nums) - 1
        zeroPtr = 0
        curr = 0
        while curr <= twoPtr:
            if nums[curr] == 0:
                nums[zeroPtr], nums[curr] = nums[curr], nums[zeroPtr]
                curr += 1
                zeroPtr += 1
            elif nums[curr] == 2:
                nums[curr], nums[twoPtr] = nums[twoPtr], nums[curr]
                twoPtr -= 1
            else:
                curr += 1