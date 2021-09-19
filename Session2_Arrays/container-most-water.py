class Solution:
    def maxArea(self, height: List[int]) -> int:
        # Left pointer
        l = 0
        # Right pointer
        r = len(height) - 1
        # Accumulator storing maximum volume
        maxVol = 0
        

        while r > l:
            # Calculate width
            w = r - l
            # Calculate lesser of the 2 heights (R, L), see question
            h = min(height[r], height[l])
            # Compare this volume with currently maximum volume
            maxVol = max(maxVol, w * h)
            
            # See which pointer needs to shift (the shorter height)
            if height[r] > height[l]:
                l += 1
            else:
                r -= 1
        
        return maxVol