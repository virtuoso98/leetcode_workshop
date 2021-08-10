class Solution:
    def fac(self, n: int) -> int:
        """
        Auxillary factorial function
        """
        if n == 0:
            return 1
        return n * self.fac(n - 1)
    
    def uniquePaths(self, m: int, n: int) -> int:
        """
        Since robots can only walk right and down, that means robot 
        must walk down m - 1 times and right n - 1 times. In total,
        this is m + n - 2 times. Since walking down is indistinguishable
        from itself as is walking right, this becomes a Permutation and
        Combination question.
        """
        return self.fac(m + n - 2) // self.fac(n - 1) // self.fac(m - 1)