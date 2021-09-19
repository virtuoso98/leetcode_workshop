class Solution {
    public int maxArea(int[] height) {
        /* Left pointer */
        int l = 0;
        /* Right pointer */
        int r = height.length - 1;
        /* Accumulator storing maximum volume */
        int maxVol = 0;
        while (r > l) {
            /* Calculate Width */
            int w = r - l;
            /* Calculate lesser of the 2 heights (R, L), see question */
            int h = Math.min(height[r], height[l]);
            /* Compare this volume with currently max volume */
            maxVol = Math.max(maxVol, w * h);

            /* See which pointer needs to shift (the shorter height) */
            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return maxVol;
    }
}