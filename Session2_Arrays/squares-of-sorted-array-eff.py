class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        # Assign new array
        res = [0] * len(nums)
        # Assign left and right forward for
        # Most negative and Most positive values
        l = 0
        r = len(nums) - 1
        # Assign pointer to last index since the square
        # of a most negative/ positive value would be
        # Highest in the new array
        ptr = len(nums) - 1
        # While new array is not completely populated
        while ptr >= 0:
            # Compare absolute magnitude
            if abs(nums[l]) > abs(nums[r]):
                res[ptr] = nums[l] ** 2
                l += 1
            else:
                res[ptr] = nums[r] ** 2
                r -= 1
            # Shift pointer for next element to be added
            ptr -= 1
            
        return res
        