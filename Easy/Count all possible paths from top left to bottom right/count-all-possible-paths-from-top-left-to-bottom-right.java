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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int m = Integer.parseInt(input[0]); 
            int n = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m,n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public Map<ArrayList<Integer>, Long> map = new HashMap<>();

    public long numberOfPaths(int row, int col)
    {
        if (row == 1 && col == 1) return 1;
        if (row < 1 || col < 1) return 0;
        long mod=(long)1e9+7;
        long a = 0;
        ArrayList<Integer> al = new ArrayList<>();
        al.add(row);
        al.add(col);
    
        if (map.containsKey(al)) return map.get(al);

        a = ((numberOfPaths(row - 1, col)) % mod + (numberOfPaths(row, col - 1))%mod)%mod;
        map.put(al, a);
        return a;
    }
}
