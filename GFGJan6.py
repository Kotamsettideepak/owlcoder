class Solution:
    def sumOfPowers(self, l: int, r : int) -> int:
        # code here
        def fun(n):
            s=0
            if n<=1:
                return 0
            while n%2==0:
                s+=1
                n=n//2
            i = 3
            while (i*i)<=n:
                while n%i==0:
                    s+=1
                    n=n//i
                i += 2    
            if n>2:
                s+=1
            return s 
        c=0
        for i in range(l,r+1):
            c+=fun(i)
        return c