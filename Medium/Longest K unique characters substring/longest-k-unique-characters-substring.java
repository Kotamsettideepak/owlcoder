//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, max = Integer.MIN_VALUE, check;
        char c;
        while (right < s.length()) {
            c = s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);
            if (map.size() == k) {
                max = Math.max(max, right - left + 1);
            }
            while (map.size() > k) {
                c = s.charAt(left);
                check = map.getOrDefault(c,0);
                if (check > 1) {
                    map.put(c, check - 1);
                } else {
                    if(check !=0)map.remove(c);
                }
                left++;
            }
            right++;
        }
        return max==Integer.MIN_VALUE ? -1 :max;
    }
}