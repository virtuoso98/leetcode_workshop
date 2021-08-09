class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        """
        Finds the number that only occurs once
        in nums, where every other element 
        occurs twice.
        """
        
        # Make frequency table
        freq_table = {}
        
        # Compute frequency. Very important syntax in dictionaries
        for i in nums:
            if i in freq_table:
                freq_table[i] += 1
            else:
                freq_table[i] = 1
        
        # Find number that only occurs once.
        for num, freq in freq_table.items():
            if freq == 1:
                return num
        