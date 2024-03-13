#User function Template for python3

class Solution:
    def __init__(self):
        self.map = {}
        self.mod = int(1e9 + 7)
    
    def countWays(self, n: int) -> int:
        if n < 0:
            return 0
        if n == 0:
            return 1
        if n in self.map:
            return self.map[n]
        
        c = (self.countWays(n - 1) % self.mod + self.countWays(n - 2) % self.mod) % self.mod
        self.map[n] = c
        return c

#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys
sys.setrecursionlimit(10**6)

# Contributed by : Nagendra Jha

if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases):
        m = int(input())
        ob=Solution()
        print(ob.countWays(m))

# } Driver Code Ends