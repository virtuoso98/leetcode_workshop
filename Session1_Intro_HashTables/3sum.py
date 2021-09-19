class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        """
        Disclaimer: not the best way of writing this algorithm.
        I kinda got lazy and bunched everything into 1 function
        and not split it to auxillary functions
        """
        output = []
        # Sort array in ascending order
        nums.sort()
        for i in range(len(nums)):
            # if lowest element is positive, then sum of triplets
            # must be positive, which is not 0.
            if nums[i] > 0:
                break
            # if first index or non-repeating starting number, start 3sum
            if i == 0 or nums[i] != nums[i - 1]:
                # pointer to last index (and hence, largest number)
                right = len(nums) - 1
                # pointer to lowest number after nums[i]
                left = i + 1
                while right > left:
                    target = nums[i] + nums[right] + nums[left]
                    # if sum is negative, then sum needs to increase. 
                    # shift left pointer to higher number
                    if target < 0:
                        left += 1  
                    # if sum is positive, then sum needs to decrease. 
                    # shift right pointer to lower number
                    elif target > 0:
                        right -= 1
                    else:
                        output.append([nums[i], nums[left], nums[right]])
                        # prevent repeating triplets
                        left += 1
                        right -= 1
                        # same function - prevent repeating triplets
                        # could also do left += 1 too!
                        while right > left and nums[right] == nums[right + 1]:
                            right -= 1  
        return output