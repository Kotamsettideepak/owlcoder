#User function Template for python3

class Solution:
    def findTwoElement( self,arr, n): 
        m=0
        r=0
        d={}
        for i in arr:
            if i in d:
                r=i
                break
            else:
                d[i]=1
        a=set(arr)
        b=set(range(1,n+1))
        b=b-a
        return [r,*b]

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 

    tc=int(input())
    while tc > 0:
        n=int(input())
        arr=list(map(int, input().strip().split()))
        ob = Solution()
        ans=ob.findTwoElement(arr, n)
        print(str(ans[0])+" "+str(ans[1]))
        tc=tc-1
# } Driver Code Ends