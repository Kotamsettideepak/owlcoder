//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s) {
        List<String> al = new ArrayList<>();
        int length = s.length();
        for (int i = 1; i <= (int) Math.pow(2, length) - 1; i++) {
            String temp = "";
            for (int j = 0; j < length; j++) {
                if (((i >> j) & 1) == 1) {
                    temp += String.valueOf(s.charAt(j));
                }
            }
            al.add(temp);
        }
        Collections.sort(al);
        return al;
    }
}