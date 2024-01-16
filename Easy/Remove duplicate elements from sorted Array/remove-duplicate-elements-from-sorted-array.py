#User function template for Python

class Solution:	
	def remove_duplicate(self, b, N):
	    d={}
	    for i in b:
	        if i in d:
	            d[i]+=1
	        else:
	            d[i]=1
        a=list(d.keys())
        a.sort()
        for i in range(len(a)):
            b[i]=a[i]
        return len(a)


#{ 
 # Driver Code Starts
#Initial template for Python

if __name__=='__main__':
    t = int(input())
    for i in range(t):
        N = int(input())
        A = list(map(int, input().strip().split()))
        ob = Solution()
        n = ob.remove_duplicate(A,N)
        for i in range(n):
            print(A[i], end=" ")
        print()


# } Driver Code Ends