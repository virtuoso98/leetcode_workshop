class Solution:
    def maxArea(self, height: List[int]) -> int:
        l = 0
        r = len(height) - 1
        maxVol = 0
        
        while r > l:
            w = r - l
            h = min(height[r], height[l])
            maxVol = max(maxVol, w * h)
            
            if height[r] > height[l]:
                l += 1
            else:
                r -= 1
        
        return maxVol