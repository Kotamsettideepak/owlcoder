//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> dictionary = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            dictionary.add(p);
                        }
                    String s = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(n, s, dictionary));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static boolean moon(String s, ArrayList<String> dictionary) {
        if (dictionary.contains(s) || s == "") {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            if (dictionary.contains(s1) && moon(s2, dictionary)) {
                return true;
            }
        }
        return false;
    }

    public static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        return moon(s, dictionary) ? 1 : 0;
    }
}