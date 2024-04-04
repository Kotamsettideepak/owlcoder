//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    //taking the String
		    String s=sc.nextLine();
		    Solution ob = new Solution();
		    //calling method sumSubstrings() 
		    System.out.println(ob.sumSubstrings(s));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static long sumSubstrings(String s){
        long prev=0,sum=0,res=0,mod=(long)1e9+7;
        for(int i=0;i<s.length();i++){
            sum=(((((int)s.charAt(i)-'0')%mod*(i+1)))%mod+(10*prev%mod)%mod)%mod;
            prev=sum;
            res= (res%mod + sum%mod)%mod;
        }
        return res;
    }
}