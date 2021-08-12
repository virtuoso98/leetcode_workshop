class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        # Complement map to save space
        comp_map = {"(" : ")", "[" : "]", "{" : "}"}
        # Unnecessary actually. Can use keys of comp_map
        open_set = {"(", "[", "{"}
        # Traverse string from left to right
        for char in s:
            if char in open_set:
                # If character classified as left bracket,
                # Push it into the stack
                stack.append(char)
            # This branch focuses on right brackets
            else:
                # No available matching left brackets
                if len(stack) == 0:
                    return False
                # If there is left bracket in stack,
                # Check if it's a suitable complement
                comp = stack.pop()
                if comp_map[comp] != char:
                    return False
        
        return len(stack) == 0