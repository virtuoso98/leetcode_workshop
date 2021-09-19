class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        # Square the numbers
        for i in range(len(nums)):
            nums[i] **= 2
        
        # Run in house sort function
        nums.sort()
        return nums