class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        # Iniitalize set of seen elements
        seen = set()
        for num in nums:
            # If number is spotted in seen set,
            # Then there is a duplicate
            if num in seen:
                return True
            # Else, add to seen set
            seen.add(num)
        
        # No duplicates are found at this point
        return False
        