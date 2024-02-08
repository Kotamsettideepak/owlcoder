//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends




// User function Template for Java

class Solution {
    public long dp[][];

    public long moon(int arr[], int i, int n, int target) {
        if(i>=n || target<0)return 0;
        
        if (dp[i][target] != -1) {
            return dp[i][target];
        }
        if (target == 0) {
            return 1;
        }
        long take=0, ntake=0;
        if (arr[i] <= target) {
            take= moon(arr, i, n, target - arr[i]);
        }
        ntake= moon(arr, i + 1, n, target);
        return dp[i][target] = ntake+take;
    }

    public long count(int coins[], int N, int sum) {
        dp = new long[N+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return moon(coins, 0, N, sum);
    }
}