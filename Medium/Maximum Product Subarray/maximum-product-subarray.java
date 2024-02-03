//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // long moon(int arr[], int i) {
    //     if (i == arr.length) {
    //         return 1;
    //     }
    //     long max = Integer.MIN_VALUE;

    //     max = Math.max(max, arr[i] * moon(arr, i + 1));
    //     max = Math.max(max, moon(arr, i + 1));
    //     return max;
    // }

    long maxProduct(int[] arr, int n) {
        long res=Integer.MIN_VALUE;
        long pro=1;
        for(int i=0;i<n;i++){
            pro=1;
            for(int j=i;j<n;j++){
                pro*=arr[j];
                if(pro>res)res=pro;
            }
        }
        return res;
    }
}