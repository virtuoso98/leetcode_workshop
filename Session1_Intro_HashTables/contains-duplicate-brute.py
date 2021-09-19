class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        """
        Brute force, inefficient implementation that
        is a case study of what's to see in two sum.
        """
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] == nums[j]:
                    return True
        
        return False