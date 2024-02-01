//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends

class Solution {
    static void moon(ArrayList<ArrayList<Integer>> r, ArrayList<Integer> l, ArrayList<Integer> arr, int t, int idx) {
        if (idx >= arr.size() || t < 0) {
            return;
        }
        if (t == 0) {
            Collections.sort(l);
            r.add(new ArrayList<>(l));
        }
        for (int i = idx; i < arr.size(); i++) {
            if (arr.get(i) <= t) {
                l.add(arr.get(i));
                moon(r, l, arr, t - arr.get(i), i);
                l.remove(l.size() - 1);
            }
        }
    }


    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> r = new ArrayList<>();
        Set<Integer> st = new HashSet<>(A);
        A = new ArrayList<>(st);
        Collections.sort(A);
        moon(r, new ArrayList<>(), A, B, 0);
        return r;
    }
}