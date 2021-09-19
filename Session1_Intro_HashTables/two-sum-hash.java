class Solution {
    public int[] twoSum(int[] nums, int target) {
        /* Maps seen number to corresponding index */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            /* Complement that adds up to target */
            int difference = target - nums[i];
            /* If difference has already been discovered (see else branch) */
            if (map.containsKey(difference)) 
            {
                int[] answer = new int[] { map.get(difference), i };
                return answer;
            }
            else 
            {
                /* If not found, add this to previously seen values */
                map.put(nums[i], i);
            }
        }
        return null;
    }
}