class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        output = []
        nums.sort()
        for i in range(len(nums)):
            if nums[i] > 0:
                break;
            if i == 0 or nums[i] != nums[i - 1]:
                right = len(nums) - 1
                left = i + 1
                while right > left:
                    target = nums[i] + nums[right] + nums[left]
                    if target < 0:
                        left += 1  
                    elif target > 0:
                        right -= 1
                    else:
                        output.append([nums[i], nums[left], nums[right]])
                        left += 1
                        right -= 1
                        while right > left and nums[right] == nums[right + 1]:
                            right -= 1  
        return output