class Solution:
    def fac(self, n: int) -> int:
        if n == 0:
            return 1
        return n * self.fac(n - 1)
    
    def uniquePaths(self, m: int, n: int) -> int:
        return self.fac(m + n - 2) // self.fac(n - 1) // self.fac(m - 1)