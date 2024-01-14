//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N) {
        ArrayList<Integer> al = new ArrayList<>();
        int c = 0;
        int temp, limit;
        for (int i = 1; i <= N; i++) {
            if (al.size() == 0)
                al.add(i);
            else {
                limit = al.size();
                c = 0;
                for (int j = 0; j < limit; j++) {
                    temp = (al.get(j) * i) + c;
                    if (temp >= 10) {
                        al.set(j, temp % 10);
                        c = temp / 10;
                    } else {
                        al.set(j, temp);
                        c = 0;
                    }
                }
                while(c!=0){
                    al.add(c%10);
                    c=c/10;
                }
            }
        }
        Collections.reverse(al);
        return al;
    }
}