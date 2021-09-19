class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        output = []
        # Sort numbers in ascending order
        nums.sort()
        for i in range(len(nums)):
            # If lowest number is positive, then sum must be positive
            # which is more than 0, so we know there are no more triplets
            if nums[i] > 0:
                break
            # start 3 sum upon non-repeating starting number or starting index
            if i == 0 or nums[i] != nums[i - 1]:
                self.threeSumAux(nums, i, output)
        return output
    
    def threeSumAux(self, nums, i, output):
        # Initialize set of seen complements
        # sets have extremely fast lookup time
        seen = set()
        j = i + 1
        while j < len(nums):
            # required complement such that sum of 3 numbers is 0
            complement = -nums[i] - nums[j]
            if complement in seen:
                output.append([nums[i], nums[j], complement])
                # prevent repetitions of triplets by shifting j
                # pointer to a different integer
                while j + 1 < len(nums) and nums[j] == nums[j + 1]:
                    j += 1
            # add number to seen set
            seen.add(nums[j])
            j += 1