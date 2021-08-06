class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int nWord = words.length;
        int nLetter = words[0].length();
        int window = nWord * nLetter;
        List ans = new ArrayList<Integer>();
        Map<String, Integer> map1 = new HashMap<>();

        for (String word : words) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < s.length() - window + 1; i++) {
            Map<String, Integer> map2 = new HashMap<>();
            for (int j = i; j < i + window; j += nLetter) {
                String fragment = s.substring(j, j + nLetter);
                map2.put(fragment, map2.getOrDefault(fragment, 0) + 1);
            }
            if (map1.equals(map2))
                ans.add(i);
        }

        return ans;
    }
}