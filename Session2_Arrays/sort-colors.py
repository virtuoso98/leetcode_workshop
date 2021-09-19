class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # Pointer to count number of 2s discovered (placed at back)
        twoPtr = len(nums) - 1
        # Pointer to count number of 0s discovered (placed in front)
        zeroPtr = 0
        # Index that loops until it encounters border between 1 and 2
        curr = 0
        # this while loop works even for cases where arr is already sorted
        while curr <= twoPtr:
            if nums[curr] == 0:
                # swap zeroPtr to occupy slot
                nums[zeroPtr], nums[curr] = nums[curr], nums[zeroPtr]
                # increase currentPtr since swapped element must be 1 or 2
                # unless it's continuous 0s, which doesn't really matter
                curr += 1
                # Since one '0' is seen, move ptr 1 unit to right
                zeroPtr += 1
            elif nums[curr] == 2:
                nums[curr], nums[twoPtr] = nums[twoPtr], nums[curr]
                # Do not increase curr ptr since swapped element could be a 0
                # Since one '2' seen, move pointer 1 unit to left
                twoPtr -= 1
            else:
                # Element encountered is a 1, nothing else needs to be done
                curr += 1