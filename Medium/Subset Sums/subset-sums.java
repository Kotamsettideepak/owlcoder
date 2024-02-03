//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    
    public void moon(ArrayList<Integer> arr, ArrayList<Integer> l, int c, int i) {
        if (i == arr.size()) {
            return;
        }
        c += arr.get(i);
        l.add(c);
        moon(arr, l, c, i + 1);
        c -= arr.get(i);
        moon(arr, l, c, i + 1);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> al = new ArrayList<>();
        moon(arr, al, 0, 0);
        al.add(0);
        Collections.sort(al);
        return al;
    }
}