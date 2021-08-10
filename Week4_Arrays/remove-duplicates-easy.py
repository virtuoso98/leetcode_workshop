class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # Edge case where array is empty
        if len(nums) == 0:
            return 0
        
        # Pointer to show number of unique elements
        uniquePtr = 0
        for i in range(1, len(nums)):
            # Array is sorted, means num[i] guaranteed unseen previously
            if nums[i] != nums[i - 1]:
                # Increase n(unique) by 1
                uniquePtr += 1
                nums[uniquePtr] = nums[i]
        
        # Since uniquePtr is zero-indexed, increase total by 1
        return uniquePtr + 1