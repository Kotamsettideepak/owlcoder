//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    void moon(StringBuilder sb, int one, int zero, int n, ArrayList<String> al) {
        if (zero > one) {
            return;
        }
        if (sb.length() == n) {
            al.add(new String(sb));
            return;
        }
        if (one >= zero) {
            sb.append("1");
            moon(sb, one + 1, zero, n, al);
            sb.deleteCharAt(sb.length() - 1);
            sb.append("0");
            moon(sb, one, zero + 1, n, al);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    ArrayList<String> NBitBinary(int N) {
        ArrayList<String> al = new ArrayList<>();
        moon(new StringBuilder("1"), 1, 0, N, al);
        return al;
    }
}