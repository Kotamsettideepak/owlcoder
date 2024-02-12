//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long sequence(int n){
        long mod=(long)1e9+7;
        long res=1,sum=0;
        int count=1;
        for(int i=1;i<=n;i++){
            int temp=i;
            res=1;
            while(temp >0){
                res=(res%mod * count%mod)%mod;
                count++;
                temp--;
            }
            sum= (sum%mod + res%mod)%mod;
        }
        return sum%(mod);
    }
}