//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
       public int findSubString(String s) {
        Set<Character> st = new HashSet<>();
        for (char c : s.toCharArray()) {
            st.add(c);
        }
        int size = st.size();
        int map[] = new int[256];
        int iHave = 0, min = Integer.MAX_VALUE, left = 0, right = 0, n = s.length(), i;
        while (right < n) {
            i = s.charAt(right);
            map[i]++;
            if (map[i] == 1) {
                iHave++;
            }
            if (iHave == size) {
                while (iHave == size) {
                    i = s.charAt(left);
                    if (map[i] == 1) {
                        map[i] = 0;
                        iHave--;
                    } else {
                        map[i]--;
                    }
                    min = Math.min(min, right - left + 1);
                    left++;
                }
            }
            right++;
        }
        return min;
    }
}