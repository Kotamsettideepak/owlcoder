//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String s){
        int arr[] = new int[26];
        int duplicate = 0;
        int right = 0, left = 0;
        int l = s.length(), i;
        int max = Integer.MIN_VALUE;
        while (right < l) {
            i = s.charAt(right) - 'a';
            arr[i]++;
            if (arr[i] > 1) {
                duplicate++;
            }
            while (duplicate != 0 && left<=right) {
                i = s.charAt(left) - 'a';
                if (arr[i] == 2) {
                    duplicate--;
                }
                arr[i]--;
                left++;
            }
            if (duplicate == 0) {
                max = Math.max(max, right - left + 1);
            }
            right++;
        }
        return max;
    }
}