//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSum(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public Map<Integer, Integer> map = new HashMap<>();

    public int moon(int n) {
        if (n==0 ) {
            return 0;
        }
        if(n==1)return 1;
        int a = (n / 2) + (n / 3) + (n / 4);
        a = Math.max(a, n);
        return Math.max(a, moon(n / 2) + moon(n / 3) + moon(n / 4));
    }

    public int maxSum(int n) {
        return moon(n);
    }

}
