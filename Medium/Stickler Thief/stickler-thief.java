//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution{
    public int dp[];

    public int moon(int arr[], int idx, int n, int[] dp) {
        if (idx >= arr.length) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int max = Integer.MIN_VALUE;
        // pick
        max = Math.max(max, arr[idx] + moon(arr, idx+2, n, dp));
        // non-pick
        max = Math.max(max, moon(arr, idx + 1, n, dp));
        dp[idx] = max;
        return max;
    }

    public int FindMaxSum(int arr[], int n) {
        dp = new int[100000];
        Arrays.fill(dp, -1);
        return moon(arr, 0, n, dp);
    }

}