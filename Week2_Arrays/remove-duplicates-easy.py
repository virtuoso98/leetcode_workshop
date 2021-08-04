class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        
        uniquePtr = 0
        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                uniquePtr += 1
                nums[uniquePtr] = nums[i]
        
        return uniquePtr + 1