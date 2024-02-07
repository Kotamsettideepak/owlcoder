//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
     public int dp[];

    public int moon(int arr[], int i, int n) {
        if (i >= n) {
            return 0;
        }
        int max = arr[i];
        if (dp[i] != -1) {
            return dp[i];
        }
        max = Math.max(max, arr[i] + moon(arr, i + 2, n));
        max = Math.max(max, moon(arr, i + 1, n));
        return dp[i] = max;
    }

    int findMaxSum(int arr[], int n) {
        dp = new int[100001];
        Arrays.fill(dp, -1);
        return moon(arr, 0, n);
    }
}
