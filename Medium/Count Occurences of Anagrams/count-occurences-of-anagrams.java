//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean isValid(int arr1[], int arr2[]) {
        return Arrays.equals(arr1, arr2);
    }

    int search(String pat, String txt) {
        int check[] = new int[256];
        for (char c : pat.toCharArray()) {
            check[c]++;
        }
        int count = 0;
        int arr[] = new int[256];
        int n = pat.length();
        for (int i = 0; i < n; i++) {
            arr[txt.charAt(i)]++;
        }
        int l = txt.length();
        int j = 0;
        for (int i = n; i < l; i++) {
            // System.out.println("Array " + Arrays.toString(arr));
            // System.out.println(Arrays.toString(check));
            if (isValid(arr, check)) {
                count++;
            }
            arr[txt.charAt(j++)]--;
            arr[txt.charAt(i)]++;
        }            
        if (isValid(arr, check)) {
            count++;
        }
        return count;
    }
}