import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        /* Initialize set of seen elements */
        Set<Integer> seen = new HashSet<>();

        for (int i : nums) {
            /* If number spotted in seen set, return True */
            if (seen.contains(i))
                return true;
            /* Else, add to seen set */
            seen.add(i);
        }

        /* No duplicates found at this point */
        return false;
    }
}