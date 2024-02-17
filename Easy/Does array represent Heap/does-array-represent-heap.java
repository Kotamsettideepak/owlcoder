//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSub(a, n) ? 1:0);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    public boolean countSub(long arr[], long n) {
        int c = 2;
        long min = arr[0];
        int pointer = 1;
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (c == 0) {
                c = 2;
                min = arr[pointer];
                pointer++;
                flag = true;
            }
            if (arr[i] > min) {
                return false;
            }
            c--;
        }
        return true;
    }
}