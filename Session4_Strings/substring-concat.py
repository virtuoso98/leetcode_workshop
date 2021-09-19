class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        """
        Disclaimer: Not the most efficient way to do this question,
        But a good way to start thinking about sliding windows.
        """
        # Number of words and number of letters per word
        nWord, nLetter = len(words), len(words[0])
        # Length of sliding window
        window = nWord * nLetter
        # output
        ans = []
        # Notice the for-loop conditions to prevent out-of-bounnds
        for i in range(0, len(s) - window + 1):
            # copy array
            temp = words.copy()
            # range of sliding window, step size set at nLetter
            for j in range(i, i + window, nLetter):
                # Collect substring
                fragment = s[j:j + nLetter]
                # Remove fragment from temp if prevent
                if fragment in temp:
                    temp.remove(fragment)
            # If empty, means that all the strings in words are 
            # contained in that particular substring. Record starting index
            if temp == []:
                ans.append(i)
        return ans