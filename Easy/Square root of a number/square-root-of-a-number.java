//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}
// } Driver Code Ends
class Solution
{
     long floorSqrt(long x)
	 {
		long i=1,j=x,mid=0,a=0;
		while(i<=j){
		    mid=(i+j)/2;
		    a=mid*mid;
		    if(a==x )return mid;
		    if(a<x)i=mid+1;
		    else j=mid-1;
		}
		if(a-x<0)return mid;
		return mid-1;
	 }
}
