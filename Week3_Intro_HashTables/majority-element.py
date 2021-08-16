class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # Initialize frequency table
        freq = {}
        # Threshold that must be exceeded based on question
        majority_threshold = len(nums) // 2
        
        for i in nums:
            # This code pattern is very, very common!
            if i in freq:
                freq[i] += 1
            else:
                freq[i] = 1
            
            # Check if this is indeed majority element
            if freq[i] > majority_threshold:
                return i
        
        # follow up for 2-pass method:
        # for k, v in freq.items():
            # if v > majority_threshold:
                # return k