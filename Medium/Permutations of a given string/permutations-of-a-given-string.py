import itertools as it
#User function Template for python3

class Solution:
    def find_permutation(self, S):
        # Code here
        S=list(S)
        a=list(it.permutations(S))
        a=set(a)
        a=list(a)
        a.sort()
        l=[]
        for i in a:
            l.append("".join(i))
        return l



#{ 
 # Driver Code Starts
#Initial Template for Python 3


if __name__ == '__main__':
	t=int(input())
	for i in range(t):
		S=input()
		ob = Solution()
		ans = ob.find_permutation(S)
		ans.sort()
		for i in ans:
			print(i,end=" ")
		print()
# } Driver Code Ends