//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    static long conquer(long arr[], long st, long mid, long en) {
        int idx1 = (int) st;
        int idx2 = (int) mid + 1;
        long merge[] = new long[(int) en - (int) st + 1];
        int p = 0;
        long c = 0;

        while (idx1 <= mid && idx2 <= en) {
            if (arr[idx1] <= arr[idx2]) {
                merge[p++] = arr[idx1++];
            } else {
                merge[p++] = arr[idx2++];
                c += (mid - idx1 + 1);
            }
        }

        while (idx1 <= mid) {
            merge[p++] = arr[idx1++];
        }

        while (idx2 <= en) {
            merge[p++] = arr[idx2++];
        }

        for (int i = (int) st, j = 0; i <= en; i++, j++) {
            arr[i] = merge[j];
        }

        return c;
    }

    static long divide(long arr[], long st, long en) {
        if (st >= en) {
            return 0;
        }
        long n = 0;
        long mid = (st + en) / 2;
        n += divide(arr, st, mid);
        n += divide(arr, mid + 1, en);
        n += conquer(arr, st, mid, en);
        return n;
    }

    static long inversionCount(long arr[], long N) {
        return divide(arr, 0, N - 1);
    }

}