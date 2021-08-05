class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        comp_map = {"(" : ")", "[" : "]", "{" : "}"}
        open_set = {"(", "[", "{"}
        for char in s:
            if char in open_set:
                stack.append(char)
            else:
                if len(stack) == 0:
                    return False
                comp = stack.pop()
                if comp_map[comp] != char:
                    return False
        
        return len(stack) == 0