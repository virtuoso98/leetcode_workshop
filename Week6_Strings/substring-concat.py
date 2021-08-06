class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        nWord, nLetter = len(words), len(words[0])
        window = nWord * nLetter
        ans = []
        for i in range(0, len(s) - window + 1):
            temp = words.copy()
            for j in range(i, i + window, nLetter):
                fragment = s[j:j + nLetter]
                if fragment in temp:
                    temp.remove(fragment)
            if temp == []:
                ans.append(i)
        return ans