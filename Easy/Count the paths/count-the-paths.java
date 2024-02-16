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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int s = Integer.parseInt(S[2]);
            int d = Integer.parseInt(S[3]);
            int[][] edges = new int[m][2];
            for(int i = 0; i < m; i++){
                String[] S1 = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(S1[0]);
                edges[i][1] = Integer.parseInt(S1[1]);
            }
            Solution obj = new Solution();
            int ans = obj.possible_paths(edges, n, s, d);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    public int moon(int s, int d) {
        int c = 0;
        if (s == d) {
            return 1;
        }
        if (map.containsKey(s)) {
            for (int i : map.get(s)) {
                c += moon(i, d);
            }
        }
        return c;
    }

    public int possible_paths(int[][] edges, int n, int s, int d) {
        int a, b;
        for (int i[] : edges) {
            a = i[0];
            b = i[1];
            if (map.containsKey(a)) {
                map.get(a).add(b);
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(b);
                map.put(a, l);
            }
        }
        return moon(s, d);
    }
}