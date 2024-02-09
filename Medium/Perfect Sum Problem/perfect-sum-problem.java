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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends



class Solution {
    public int[][] dp;

    public int moon(int arr[], int i, int t, int n) {
        int mod = (int) 1e9 + 7;
        if (t < 0) {
            return 0;
        }
        if (i >= n) {
            if (t == 0) {
                return 1;
            }
            return 0;
        }
        if (dp[i][t] != -1) return dp[i][t];
        
        int pick = 0, npick = 0;
        if (arr[i] <= t) {
            pick = (pick % mod + moon(arr, i + 1, t - arr[i], n) % mod) % mod;
        }
        npick = (npick % mod + moon(arr, i + 1, t, n) % mod) % mod;
        
        return dp[i][t] = (pick + npick) % mod;
    }

    public int perfectSum(int arr[], int n, int sum) {
        dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return moon(arr, 0, sum, n);
    }
}
