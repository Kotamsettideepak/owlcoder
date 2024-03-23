//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int ans[] = obj.Series(n);
            for (int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    
    Map<Integer,Integer> map = new HashMap<>();
    int mod= (int)1e9+7;
    int fib(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        if(map.containsKey(n))return map.get(n);
        int a= (fib(n-1)%mod+fib(n-2)%mod)%mod;
        map.put(n,a);
        return a;
    }
    int[] Series(int n) {
        // code here
        int arr[]= new int[n+1];
        for(int i=0;i<=n;i++){
            arr[i]=fib(i);
        }
        return arr;
    }
}