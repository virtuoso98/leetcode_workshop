class Solution {
    /**
     * Disclaimer: Not the most efficient solution to find
     * the answer, but it's a good way to start thinking about
     * Sliding windows
     */
    public List<Integer> findSubstring(String s, String[] words) {
        /* Find number of words */
        int nWord = words.length;
        /* Number of letters per word */
        int nLetter = words[0].length();
        /* Required sliding window */
        int window = nWord * nLetter;
        /* Answer storing the starting indexes */
        List ans = new ArrayList<Integer>();
        /* Hashmap equivalent of String[] words (parameter) */
        Map<String, Integer> map1 = new HashMap<>();

        /* Populate map with word count */
        for (String word : words) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }

        /* Notice the for-loop constraints to prevent Out-of-Bounds */
        for (int i = 0; i < s.length() - window + 1; i++) {
            /* HashMap to record all words that's inside */
            Map<String, Integer> map2 = new HashMap<>();
            /* For-loop to populate map2 with word counts */
            for (int j = i; j < i + window; j += nLetter) {
                String fragment = s.substring(j, j + nLetter);
                map2.put(fragment, map2.getOrDefault(fragment, 0) + 1);
            }
            /* If word count equal to previous map, add to answer */
            if (map1.equals(map2))
                ans.add(i);
        }

        return ans;
    }
}