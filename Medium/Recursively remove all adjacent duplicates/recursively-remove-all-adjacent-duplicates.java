//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            String ans = ob.rremove(S).trim();
            if(ans.length() == 0)
                System.out.println();
            else
                System.out.println(ans);
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    String rremove(String s) {
        StringBuilder temp=new StringBuilder();
        boolean duplicate=false;
        boolean change=false;
        char arr[]=s.toCharArray();
        for (char c : arr) {
            if (temp.length() == 0) {
                temp.append(c);
            } else if (temp.charAt(temp.length() - 1) == c) {
                duplicate = true;
                change = true;
            } else {
                if (duplicate) {
                    duplicate = false;
                    temp.deleteCharAt(temp.length() - 1);
                }
                temp.append(c);
            }
        }

        if (duplicate) {
            temp.deleteCharAt(temp.length() - 1);
        }

        if (change) {
            return rremove(temp.toString());
        } else {
            return temp.toString();
        }
    }
}
