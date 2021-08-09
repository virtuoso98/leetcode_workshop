class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        More efficient implementation of twoSum that memorizes
        previous result to speed up execution time
        """
        # Create table of number to corresponding index
        table = {}
        for i in range(len(nums)):
            # if complement has already been seen
            if target - nums[i] in table:
                return [i, table[target - nums[i]]]
            else:
                # Add number to discovered numbers
                table[nums[i]] = i