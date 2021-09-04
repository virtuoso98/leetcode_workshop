class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        res = [0] * len(nums)
        l = 0
        r = len(nums) - 1
        ptr = len(nums) - 1
        while ptr >= 0:
            if abs(nums[l]) > abs(nums[r]):
                res[ptr] = nums[l] ** 2
                l += 1
            else:
                res[ptr] = nums[r] ** 2
                r -= 1
            ptr -= 1
            
        return res
        