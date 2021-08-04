class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxVol = 0;
        while (r > l) {
            int w = r - l;
            int h = Math.min(height[r], height[l]);
            maxVol = Math.max(maxVol, w * h);

            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return maxVol;
    }
}