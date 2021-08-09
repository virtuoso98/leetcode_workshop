class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        Brute force implementation that checks for sum of all
        possible pairwise permutations and returning when
        it matches target sum
        """
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        